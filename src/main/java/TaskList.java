import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> tasksList;

    public TaskList() {
        tasksList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public Task getTask(int index) {
        return tasksList.get(index);
    }

    public ArrayList<Task> getAllTasks() {
        return tasksList;
    }

    public int getSize() {
        return tasksList.size();
    }

    public void addTask(Task t) {
        tasksList.add(t);
        System.out.println("Got it. I've added this task:\n" + t.toString());
        System.out.println("Now you have " + tasksList.size() + " tasks in the list.");
    }

    public void removeTask(int index) {
        Task t = tasksList.remove(index);
        System.out.println("Ok, I've removed this task:\n" + t.toString());
        System.out.println("There are " + tasksList.size() + " remaining tasks.");
    }

    public void getList() {
        System.out.println("List of tasks:");
        for (int i = 0; i < this.getSize(); i++) {
            Task currTask = tasksList.get(i);
            System.out.println(i + 1 + "." + currTask.toString());
        }
    }
}
