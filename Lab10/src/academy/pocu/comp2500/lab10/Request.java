package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    private String movieTitle;
    private User user;

    public Request(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected String getMovieTitle() {
        return movieTitle;
    }

    protected User getUser() {
        return user;
    }


}
