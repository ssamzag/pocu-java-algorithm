package academy.pocu.comp2500.lab10.App;

import academy.pocu.comp2500.lab10.*;
import academy.pocu.comp2500.lab10.pocuflix.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
        {
            UnauthorizedResult result = new UnauthorizedResult();

            ResultValidator validator = new ResultValidator(result);

            validator.isValid(ResultCode.UNAUTHORIZED); // true
            validator.isValid(ResultCode.OK); // false
        }
        {
            MovieStore mvStore = new MovieStore();
            mvStore.add(new Movie("S", Rating.PG, 120));
            mvStore.add(new Movie("E", Rating.PG, 120));
            mvStore.add(new Movie("X", Rating.PG, 120));
            mvStore.add(new Movie("Y", Rating.PG, 120));

            User user1 = new User("시미켄", "유이");
            User user2 = new User("시노자키", "아이");
            HashSet<User> users = new HashSet<>();
            users.add(user1);
            users.add(user2);

            AuthorizationMiddleware authMiddleware = new AuthorizationMiddleware(mvStore, users);

            Request req1 = new Request("S");
            req1.setUser(user1);

            ResultBase authResult1 =  authMiddleware.handle(req1);

            assert authResult1.getCode() == ResultCode.OK;

            User user3 = new User("이명박", "박근혜");
            req1.setUser(user3);

            authResult1 = authMiddleware.handle(req1);
            assert authResult1.getCode() == ResultCode.UNAUTHORIZED;

            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            MaintenanceMiddleware maintenanceMiddleware = new MaintenanceMiddleware(mvStore, now);
            ResultBase mainResult = maintenanceMiddleware.handle(req1);

            //assert mainResult.getCode() == ResultCode.SERVICE_UNAVAILABLE;

            Request req2 = new Request("G");
            req2.setUser(user1);

            AuthorizationMiddleware auth2mw = new AuthorizationMiddleware(mvStore, users);
            ResultBase result2 = auth2mw.handle(req2);

            assert result2.getCode() == ResultCode.NOT_FOUND;


            MaintenanceMiddleware mainMw2 = new MaintenanceMiddleware(mvStore, now.plusHours(-1));
            ResultBase mainResult2 = mainMw2.handle(req2);
            assert mainResult2.getCode() == ResultCode.NOT_FOUND;

            MaintenanceMiddleware mainMw3 = new MaintenanceMiddleware(mvStore, now.plusHours(-3));
            ResultBase mainResult3 = mainMw3.handle(req2);

            assert mainResult3.getCode() == ResultCode.NOT_FOUND;

        }

        {
            UnauthorizedResult unResult = new UnauthorizedResult();
            ResultValidator validator = new ResultValidator(unResult);
            assert (validator.isValid(ResultCode.UNAUTHORIZED));

            var okResult  = new OkResult(new Movie("dd",Rating.G, 33));
            ResultValidator validator2 = new ResultValidator(okResult);
            assert (validator2.isValid(ResultCode.OK));

            var notResult = new NotFoundResult();
            ResultValidator validator3 = new ResultValidator(notResult);
            assert (validator3.isValid(ResultCode.NOT_FOUND));

        }


        MovieStore store = new MovieStore();

        store.add(new Movie("Harry Potter", Rating.PG13, 180));
        store.add(new Movie("The Lord of the Rings", Rating.R, 180));

        {
            assert (!store.remove(2));
            assert (store.remove(1));
            Request request = new Request("None");

            ResultBase result = store.handle(request);

            assert (result.getCode() == ResultCode.NOT_FOUND);
            assert (result instanceof NotFoundResult);

            request = new Request("Harry Potter");

            result = store.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            OkResult okResult = (OkResult) result;

            assert (okResult.getMovie().getTitle().equals("Harry Potter"));
            assert (okResult.getMovie().getRating() == Rating.PG13);
            assert (okResult.getMovie().getPlayTime() == 180);
        }

        {
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            OffsetDateTime startDateTime = now.plusSeconds(1);
            OffsetDateTime endDateTime = startDateTime.plusHours(1);

            MaintenanceMiddleware middleware = new MaintenanceMiddleware(store, startDateTime);

            Request request = new Request("Harry Potter");

            ResultBase result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            sleep(2);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.SERVICE_UNAVAILABLE);
            assert (result instanceof ServiceUnavailableResult);

            ServiceUnavailableResult serviceUnavailableResult = (ServiceUnavailableResult) result;

            assert (serviceUnavailableResult.getStartDateTime().compareTo(startDateTime) == 0);
            assert (serviceUnavailableResult.getEndDateTime().compareTo(endDateTime) == 0);
        }
        {

        }

        {
            HashSet<User> users = new HashSet<>();
            users.add(new User("Jane", "Doe"));

            AuthorizationMiddleware middleware = new AuthorizationMiddleware(store, users);

            Request request = new Request("Harry Potter");

            ResultBase result = middleware.handle(request);

            assert (result.getCode() == ResultCode.UNAUTHORIZED);
            assert (result instanceof UnauthorizedResult);

            UnauthorizedResult unauthorizedResult = (UnauthorizedResult) result;

            assert (unauthorizedResult.getErrorMessage().equals("Unauthorized access"));

            request = new Request("Harry Potter");
            request.setUser(new User("James", "Bob"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.UNAUTHORIZED);
            assert (result instanceof UnauthorizedResult);

            unauthorizedResult = (UnauthorizedResult) result;

            assert (unauthorizedResult.getErrorMessage().equals("Unauthorized access"));

            request = new Request("Harry Potter");
            request.setUser(new User("Jane", "Doe"));

            result = middleware.handle(request);



            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);
        }

        {
            CacheMiddleware middleware = new CacheMiddleware(store, 3);

            Request request = new Request("Harry Potter");

            ResultBase result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.NOT_MODIFIED);
            assert (result instanceof CachedResult);

            CachedResult cachedResult = (CachedResult) result;

            assert (cachedResult.getExpiryCount() == 2);

            request = new Request("Harry Potter");
            request.setUser(new User("Jane", "Doe"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.NOT_MODIFIED);
            assert (result instanceof CachedResult);

            cachedResult = (CachedResult) result;

            assert (cachedResult.getExpiryCount() == 1);

            request = new Request("Harry Potter");
            request.setUser(new User("Jane", "Doe"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.NOT_MODIFIED);
            assert (result instanceof CachedResult);

            cachedResult = (CachedResult) result;

            assert (cachedResult.getExpiryCount() == 2);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);
        }
        {
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

            ResultBase result = new ServiceUnavailableResult(now, now);

            ResultValidator validator = new ResultValidator(result);

            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));
            assert (!validator.isValid(ResultCode.OK));
            assert (!validator.isValid(ResultCode.NOT_FOUND));
        }

        {
            User user0 = new User("user0", "userpw0");
            User user1 = new User("user1", "userpw1");
            User user2 = new User("user2", "userpw2");

            Request request0 = new Request("Movie 0");
            Request request1 = new Request("Movie 1");
            Request request2 = new Request("Movie 2");
            Request request3 = new Request("Unknown Movie");
            Request request4 = new Request("Unknown Movie");

            request0.setUser(user0);
            request1.setUser(user1);
            request2.setUser(user2);
            request3.setUser(user0); // authorized
            request4.setUser(user2); // unauthorized

            Movie movie0 = new Movie("Movie 0", Rating.R, 180);
            Movie movie1 = new Movie("Movie 1", Rating.PG, 60);
            Movie movie2 = new Movie("Movie 2", Rating.PG13, 70);

            MovieStore movieStore = new MovieStore();
            movieStore.add(movie0);
            movieStore.add(movie1);
            movieStore.add(movie2);

            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            OffsetDateTime startDateTime = now.plusSeconds(5);
            OffsetDateTime endDateTime = startDateTime.plusHours(1);
            MaintenanceMiddleware maintenanceMiddleware = new MaintenanceMiddleware(movieStore, startDateTime);

            HashSet<User> authorizedUserSet = new HashSet<>();
            authorizedUserSet.add(user0);
            authorizedUserSet.add(user1);
            AuthorizationMiddleware authorizationMiddleware = new AuthorizationMiddleware(maintenanceMiddleware, authorizedUserSet);

            CacheMiddleware cacheMiddleware = new CacheMiddleware(authorizationMiddleware, 2);

            ResultBase result = cacheMiddleware.handle(request2);
            ResultValidator validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.UNAUTHORIZED));

            result = cacheMiddleware.handle(request3);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.NOT_FOUND));

            result = cacheMiddleware.handle(request4);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.UNAUTHORIZED));

            result = cacheMiddleware.handle(request0);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.OK));

            result = cacheMiddleware.handle(request0);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.NOT_MODIFIED));
            assert (((CachedResult) result).getExpiryCount() == 1);

            result = cacheMiddleware.handle(request1);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.OK));

            result = cacheMiddleware.handle(request1);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.NOT_MODIFIED));
            assert (((CachedResult) result).getExpiryCount() == 1);

            result = cacheMiddleware.handle(request0);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.OK));

            result = cacheMiddleware.handle(request1);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.OK));

            result = cacheMiddleware.handle(request0); // remove cache
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.NOT_MODIFIED));
            assert (((CachedResult) result).getExpiryCount() == 1);

            result = cacheMiddleware.handle(request1); // remove cache
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.NOT_MODIFIED));
            assert (((CachedResult) result).getExpiryCount() == 1);

            sleep(10); // maintenance

            result = cacheMiddleware.handle(request2);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.UNAUTHORIZED));

            result = cacheMiddleware.handle(request3);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

            result = cacheMiddleware.handle(request4);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.UNAUTHORIZED));

            result = cacheMiddleware.handle(request0);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

            result = cacheMiddleware.handle(request0);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

            result = cacheMiddleware.handle(request1);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

            result = cacheMiddleware.handle(request1);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

            result = cacheMiddleware.handle(request0);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

            result = cacheMiddleware.handle(request1);
            validator = new ResultValidator(result);
            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));

        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
