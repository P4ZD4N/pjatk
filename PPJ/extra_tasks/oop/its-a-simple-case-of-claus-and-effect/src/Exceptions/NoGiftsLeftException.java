package Exceptions;

public class NoGiftsLeftException extends RuntimeException {
    public NoGiftsLeftException(String message) {
        super(message);
    }
}
