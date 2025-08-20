public class Task {
    protected String desciption;
    protected boolean isDone;

    public Task(String description) {
        this.desciption = description;
        this.isDone = false;
    }

    public String getDesciption() {
        return this.desciption;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String addTaskDisplay() {
        return "Got it. I've added this task:\n" + this.toString();
    }

    public int getTaskIndex() {
        String[] arr = this.desciption.split(" ");
        int index = Integer.parseInt(arr[1]) - 1;
        return index;
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + this.getStatusIcon() + "] " + this.desciption);
    }

    public void markAsNotDone() {
        this.isDone = false;
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.println("[" + this.getStatusIcon() + "] " + this.desciption);
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.desciption;
    }
}
