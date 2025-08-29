package khat.ui;

import khat.task.Task;

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

    public void showTasks(ArrayList<Task> tasks) {
        System.out.println("List of tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task currTask = tasks.get(i);
            System.out.println(i + 1 + "." + currTask.toString());
        }
    }

}
