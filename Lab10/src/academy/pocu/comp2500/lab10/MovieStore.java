package academy.pocu.comp2500.lab10;

import java.util.ArrayList;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;

public class MovieStore implements IRequestHandler {
    private final ArrayList<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        this.movies.add(movie);
    }

    public boolean remove(int index) {
        if (movies.size() <= index) {
            return false;
        }

        movies.remove(index);
        return true;
    }

    @Override
    public ResultBase handle(Request request) {
        for (Movie movie : this.movies) {
            if (movie.getTitle().equals(request.getMovieName())) {
                return new OkResult(movie);
            }
        }
        return new NotFoundResult();
    }
}