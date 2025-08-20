public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void addTaskDisplay() {
        System.out.println("Got it. I've added this task:\n" + this.toString());
    }

    public void removeTaskDisplay() {
        System.out.println("Ok, I've removed this task:\n" + this.toString());
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this.toString());
    }

    public void markAsNotDone() {
        this.isDone = false;
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
