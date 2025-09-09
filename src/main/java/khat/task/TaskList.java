package khat.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
     * Filters all deadline tasks on a specified deadline date.
     *
     * @param date Date to filter deadlines by.
     */
    public TaskList getTasksOnDate(LocalDate date) {
        List<Task> filtered = tasks.stream()
                .filter(task -> task instanceof Deadline)
                .filter(task -> {
                    Deadline d = (Deadline) task;
                    return d.hasTime()
                            ? d.dateTime.toLocalDate().equals(date)
                            : d.date.equals(date);
                })
                .toList();
        return new TaskList(new ArrayList<>(filtered));
    }

    /**
     * Filters all tasks with the specified keyword.
     *
     * @param keyword Keyword to filter tasks by.
     */
    public TaskList getTasksWithKeyword(String keyword) {
        List<Task> filtered = tasks.stream()
                .filter(t -> t.getDescription().contains(keyword))
                .toList();
        return new TaskList(new ArrayList<>(filtered));
    }
}
