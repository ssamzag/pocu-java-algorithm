package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class AuthorizationMiddleware {
    private IRequestHandler requestStore;
    private User user;

    public AuthorizationMiddleware(IRequestHandler requestStore, User user) {
        this.requestStore = requestStore;
        this.user = user;
    }
}
