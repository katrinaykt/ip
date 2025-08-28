package khat.task;

import java.time.LocalDate;
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
    }

    public void removeTask(int index) {
        tasksList.remove(index);
    }

    public void printTasksOnDate(LocalDate date) {
        int count = 0;
        System.out.println("Deadlines on " + date + ":");
        for (int i = 0; i < tasksList.size(); i++) {
            Task currTask = tasksList.get(i);
            boolean match = false;
            if (currTask instanceof Deadline) {
                Deadline d = (Deadline) currTask;
                if (d.hasTime()) {
                    match = d.dateTime.toLocalDate().equals(date);
                } else {
                    match = d.date.equals(date);
                }
            }
            if (match) {
                System.out.println(count + 1 + "." + currTask.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No deadlines on " + date);
        }
    }

    public void getTaskList() {
        System.out.println("List of tasks:");
        for (int i = 0; i < this.getSize(); i++) {
            Task currTask = tasksList.get(i);
            System.out.println(i + 1 + "." + currTask.toString());
        }
    }
}
