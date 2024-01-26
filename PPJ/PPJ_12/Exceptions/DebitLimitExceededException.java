package Exceptions;

public class DebitLimitExceededException extends RuntimeException {
    public DebitLimitExceededException(String message) {
        super(message);
    }
}
