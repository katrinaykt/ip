package khat.exception;

public class KhatException extends RuntimeException {

    public KhatException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
