package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashMap;
import java.util.Map;

public class CacheMiddleware implements IRequestHandler {
    private final IRequestHandler requestStore;
    private final int expiryCount;
    private final HashMap<Request, Integer> cachedRequests = new HashMap<>();

    public CacheMiddleware(IRequestHandler requestStore, int expiryCount) {
        this.requestStore = requestStore;
        this.expiryCount = expiryCount;
    }

    @Override
    public ResultBase handle(Request request) {
        ResultBase result = requestStore.handle(request);

        if (result.getCode() != ResultCode.OK) {
            return result;
        }

        Request cachedRequest = null;
        for (Map.Entry<Request, Integer> requestMap : cachedRequests.entrySet()) {
            if (!requestMap.getKey().getMovieName().equals(request.getMovieName())) {
                continue;
            }
            User cachedUser = requestMap.getKey().getUser();
            if (cachedUser == null && request.getUser() == null) {
                cachedRequest = requestMap.getKey();
                break;
            } else if (cachedUser != null && cachedUser.equals(request.getUser())) {
                cachedRequest = requestMap.getKey();
                break;
            }
        }

        if (cachedRequest != null) {
            int remainedCount = cachedRequests.get(cachedRequest);

            if (remainedCount == 1) {
                cachedRequests.put(cachedRequest, expiryCount);
                return result;
            } else {
                cachedRequests.put(cachedRequest, --remainedCount);
                return new CachedResult(remainedCount);
            }
        }

        cachedRequests.put(request, expiryCount);
        return result;
    }

    public int getExpiryCount() {
        return expiryCount;
    }
}