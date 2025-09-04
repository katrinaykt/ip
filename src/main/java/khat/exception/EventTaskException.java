package khat.exception;

/**
 * Represents an exception thrown when an event task is invalid or missing required information.
 */
public class EventTaskException extends KhatException {

    public EventTaskException(String e) {
        super("Add an event task in the format 'event [task] /from [start] /to [end]!'");
    }

}
