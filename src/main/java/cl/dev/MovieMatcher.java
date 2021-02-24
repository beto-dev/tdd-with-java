package cl.dev;

@FunctionalInterface
public interface MovieMatcher {

    boolean matches(Movie movie);
}
