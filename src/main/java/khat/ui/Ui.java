package khat.ui;

import java.util.ArrayList;
import java.util.Scanner;

import khat.task.Task;
import khat.task.TaskList;

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
