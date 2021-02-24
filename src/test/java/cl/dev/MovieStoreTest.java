package cl.dev;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {

    private final Movie harryPotter = new Movie("Harry Potter", "J.K Rowling", 2001);
    private final Movie starWars = new Movie("Star Wars", "George Lucas", 2008);
    private final Movie starTrek = new Movie("Star Trek", "George Lucas", 1993);
    private final MovieStore movieStore = new MovieStore();

    @Before
    public void setUp() {
        movieStore.add(harryPotter);
        movieStore.add(starWars);
        movieStore.add(starTrek);
    }

    @Test
    public void shouldReturnsNoResultWhenNoTitlesPartiallyMatchSearch() {
        List<Movie> movies = movieStore.findByPartialTitle("abc");

        assertThat(movies.size(), is(0));
    }

    @Test
    public void shouldFindMoviesWhenTitlesPartiallyMatched() {
        List<Movie> movies = movieStore.findByPartialTitle("tar");

        assertThat(movies.size(), is(2));
        assertThat(movies, containsInAnyOrder(starTrek, starWars));
    }

    @Test
    public void shouldFindMoviesWhenDirectorExactlyMatches() {
        List<Movie> movies = movieStore.findByDirector("George Lucas");

        assertThat(movies.size(), is(2));
        assertThat(movies, containsInAnyOrder(starTrek, starWars));

    }

    @Test
    public void shouldFinMoviesWhenReleaseIsBetweenTwoDatesInclusive() {
        List<Movie> movies = movieStore.findByReleaseYear(2000, 2010);

        assertThat(movies.size(), is(2));
        assertThat(movies, containsInAnyOrder(starWars, harryPotter));
    }
}