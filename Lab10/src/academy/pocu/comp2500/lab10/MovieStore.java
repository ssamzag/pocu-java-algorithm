package academy.pocu.comp2500.lab10;

import java.util.ArrayList;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;

public class MovieStore extends ResultBase implements IRequestHandler {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieStore(ResultCode code) {
        super(code);
    }

    public void add(Movie movie) {
        this.movies.add(movie);
    }

    public boolean remove(int index) {
        if (movies.get(index) != null) {
            movies.remove(index);
            return true;
        }
        return false;
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
