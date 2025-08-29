package khat.ui;

import khat.task.Task;
import khat.task.TaskList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private Scanner scanner = new Scanner(System.in);
    private static final String DIVIDER = "___________________________________";

    public void showWelcome() {
        System.out.println("Hello! I'm Khat.\nStart keeping track of all your tasks by sending a short command!");
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showDivider() {
        System.out.println(DIVIDER);
    }

    public void showLoadingError() {
        System.out.println("Error loading previous tasks! Creating a new task list.");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showTasks(TaskList tasks) {
        ArrayList<Task> taskArr = tasks.getAllTasks();
        System.out.println("List of tasks:");
        for (int i = 0; i < taskArr.size(); i++) {
            Task currTask = taskArr.get(i);
            System.out.println(i + 1 + "." + currTask.toString());
        }
    }

    public void showTasksOnDate(TaskList tasks, LocalDate date) {
        ArrayList<Task> taskArr = tasks.getAllTasks();
        if (taskArr.size() > 0) {
            System.out.println("Deadlines on " + date + ":");
            for (int i = 0; i < taskArr.size(); i++) {
                Task currTask = taskArr.get(i);
                System.out.println(i + 1 + "." + currTask.toString());
            }
        } else {
            System.out.println("No deadlines on " + date);
        }
    }

}
