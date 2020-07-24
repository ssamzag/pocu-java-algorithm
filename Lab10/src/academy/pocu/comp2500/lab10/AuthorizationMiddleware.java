package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler requestStore;
    private HashSet<User> users;

    public AuthorizationMiddleware(IRequestHandler requestStore, HashSet<User> users) {
        this.requestStore = requestStore;
        this.users = users;
    }

    @Override
    public ResultBase handle(Request request) {
        ResultBase result = this.requestStore.handle(request);

        if (users.contains(request.getUser())) {
            return result;
        }

        return new UnauthorizedResult();
    }
}
