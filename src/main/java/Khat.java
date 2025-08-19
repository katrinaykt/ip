import java.util.Scanner;

public class Khat {
    public static void main(String[] args) {

        int commandCounter = 0;
        Task[] tasksList = new Task[100];
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Hello! I'm Khat.\nWhat can I do for you?");
        String command = userInputScanner.nextLine(); // task description
        Task t = new Task(command);

        while (!t.getCommand().equals("bye")) {
            if (t.getCommand().equals("list")) {

                System.out.println("List of tasks:");
                for (int i = 0; i < commandCounter; i++) {
                    Task currTask = tasksList[i];
                    System.out.println(i + 1 + "." + currTask.toString());
                }
                t = new Task(userInputScanner.nextLine());

            } else if (t.getCommand().contains("mark")) {
                int index = t.getIndexTask() - 1;
                Task curr = tasksList[index];
                curr.markAsDone();
                t = new Task(userInputScanner.nextLine());

            } else { //adding tasks
                System.out.println(t.addTaskDisplay());
                tasksList[commandCounter] = t;
                commandCounter++;
                t = new Task(userInputScanner.nextLine());
            }

        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
