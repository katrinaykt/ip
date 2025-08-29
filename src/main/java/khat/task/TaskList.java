package khat.task;

import java.time.LocalDate;
import java.util.ArrayList;

/** Represents a list of tasks. */
public class TaskList {

    protected ArrayList<Task> tasks;

    /** Constructs an empty TaskList */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with given list of tasks.
     *
     * @param tasks Initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns Task at the given index.
     *
     * @param index Index of task to retrieve.
     * @return Task at the given index.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the TaskList.
     *
     * @return Size of task list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds a task to the task list.
     *
     * @param t Task to be added.
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Removes a task from the task list at the specified index.
     *
     * @param index Index of task to be removed.
     */
    public void removeTask(int index) {
        tasks.remove(index);
    }

    /**
     * Prints all deadline tasks on a specified deadline date.
     *
     * @param date Date to filter deadlines by.
     */
    public TaskList getTasksOnDate(LocalDate date) {
        TaskList t = new TaskList();
        for (int i = 0; i < tasks.size(); i++) {
            Task currTask = tasks.get(i);
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
                t.addTask(currTask);
            }
        }
        return t;
    }

}
