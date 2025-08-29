package khat.task;

/** Represents an Event task */
public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Constructs an Event task with the given description, completion status,
     * start date/time and end date/time.
     *
     * @param description Description of task.
     * @param isDone True if task is completed, false otherwise.
     * @param from Start date/time of the event.
     * @param to End date/time of the event.
     */
    public Event(String description, boolean isDone, String from, String to) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toSaveString() {
        return "E | " + (this.isDone? "1" : "0") + " | " + this.getDescription() + " | " + this.from + "-" + this.to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }
}
