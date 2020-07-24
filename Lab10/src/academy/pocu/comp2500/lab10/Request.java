package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    private String movieName;
    private User user;

    public Request(String movieName) {
        this.movieName = movieName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMovieName() {
        return movieName;
    }

    public User getUser() {
        return user;
    }


}
