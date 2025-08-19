public class Task {
    protected String command;
    protected boolean isDone;

    public Task(String command) {
        this.command = command;
        this.isDone = false;
    }

    public String getCommand() {
        return this.command;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String addTaskDisplay() {
        return "added: " + this.command;
    }

    public int getTaskIndex() {
        String[] arr = this.command.split(" ");
        int index = Integer.parseInt(arr[1]) - 1;
        return index;
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + this.getStatusIcon() + "] " + this.command);
    }

    public void markAsNotDone() {
        this.isDone = false;
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.println("[" + this.getStatusIcon() + "] " + this.command);
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.command;
    }
}
