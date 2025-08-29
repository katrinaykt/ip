package khat.exception;

/**
 * Represents a exception for errors that occur in the Khat chatbot.
 */
public class KhatException extends RuntimeException {

    public KhatException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
