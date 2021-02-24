package cl.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieStore {

    private final List<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    private List<Movie> findBy(MovieMatcher matcher) {
        return movies.stream()
                .filter(matcher::matches)
                .collect(Collectors.toList());
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        return findBy(movie -> movie.getTitle().toLowerCase().contains(partialTitle.toLowerCase()));
    }

    public List<Movie> findByDirector(String director) {
        return findBy(movie -> movie.getDirector().equalsIgnoreCase(director));
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        return findBy(movie -> movie.getReleaseYear() >= from && movie.getReleaseYear() <= to);
    }

}
