package khat.exception;

public class EventTaskException extends KhatException {

    public EventTaskException(String e) {
        super(e);
    }

    @Override
    public String toString() {
        return "EventTaskException:" + getMessage();
    }
}
