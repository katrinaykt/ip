package khat.exception;

public class DeadlineTaskException extends KhatException {

    public DeadlineTaskException(String e) {
        super(e);
    }

    @Override
    public String toString() {
        return "DeadlineTaskException: " + getMessage();
    }
}
