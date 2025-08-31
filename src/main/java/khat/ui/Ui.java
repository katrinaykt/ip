package khat.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import khat.task.Task;
import khat.task.TaskList;

/**
 * Handles all user interface interactions.
 * It displays messages, read user commands, and shows information about tasks.
 */
public class Ui {

    private static final String DIVIDER = "___________________________________";
    private Scanner scanner = new Scanner(System.in);

    /**
     * Shows welcome message.
     */
    public void showWelcome() {
        System.out.println("Hello! I'm Khat.\nStart keeping track of all your tasks by sending a short command!");
    }

    /**
     * Shows exit message.
     */
    public void showExit() {
        System.out.println("BYE. Hope to see you again soon!");
    }

    /**
     * Reads command from user input.
     *
     * @return Command entered by user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /** Shows divider line. */
    public void showDivider() {
        System.out.println(DIVIDER);
    }

    /** Shows an error message when loading previous tasks fails. */
    public void showLoadingError() {
        System.out.println("Error loading previous tasks! Creating a new task list.");
    }

    /**
     * Shows a custom message to the user.
     *
     * @param message The message to display.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Shows the list of all tasks.
     *
     * @param tasks The task list containing all tasks.
     */
    public void showTasks(TaskList tasks) {
        ArrayList<Task> taskArr = tasks.getAllTasks();
        System.out.println("List of tasks:");
        for (int i = 0; i < taskArr.size(); i++) {
            Task currTask = taskArr.get(i);
            System.out.println(i + 1 + "." + currTask.toString());
        }
    }

    /**
     * Shows the tasks occurring on a specific date.
     *
     * @param tasks The task list containing filtered tasks.
     * @param date The date to display tasks for.
     */
    public void showTasksOnDate(TaskList tasks, LocalDate date) {
        ArrayList<Task> taskArr = tasks.getAllTasks();
        if (!taskArr.isEmpty()) {
            System.out.println("Deadlines on " + date + ":");
            for (int i = 0; i < taskArr.size(); i++) {
                Task currTask = taskArr.get(i);
                System.out.println(i + 1 + "." + currTask.toString());
            }
        } else {
            System.out.println("No deadlines on " + date);
        }
    }

    /**
     * Shows the tasks in task list with specified keyword.
     *
     * @param tasks The task list containing filtered tasks.
     * @param keyword Keyword to filter tasks by.
     */
    public void showTasksWithKeyword(TaskList tasks, String keyword) {
        if (tasks.getSize() > 0) {
            System.out.printf("Here are the matching tasks in your list with keyword '%s':\n", keyword);
            for (int i = 0; i < tasks.getSize(); i++) {
                Task t = tasks.getTask(i);
                System.out.println(i + 1 + "." + t.toString());
            }
        } else {
            System.out.println("There are no matching tasks!");
        }
    }

}
