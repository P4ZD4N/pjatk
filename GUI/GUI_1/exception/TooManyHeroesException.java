package exception;

public class TooManyHeroesException extends RuntimeException {
    public TooManyHeroesException() {
        super("Too many heroes!");
    }
}
