package khat.task;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, boolean isDone, String from, String to) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    public String toSaveString() {
        return "E | " + (this.isDone? "1" : "0") + " | " + this.getDescription() + " | " + this.from + "-" + this.to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }
}
