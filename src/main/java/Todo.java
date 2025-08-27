public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    public String toSaveString() {
        return "T | " + (this.isDone? "1" : "0") + " | " + this.getDescription();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
