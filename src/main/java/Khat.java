import java.util.Scanner;

public class Khat {
    public static void main(String[] args) {

        int commandCounter = 0;
        Task[] tasksList = new Task[100];
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Hello! I'm Khat.\nWhat can I do for you?");

        while (true) {
            String command = userInputScanner.nextLine(); // task description with type
            String[] taskArr = command.split("/"); // idx 0 - description, 1 - by/from, 2 - to
            String type = command.split(" ")[0]; // type of task/ mark/unmark
            String description = taskArr[0].substring(taskArr[0].indexOf(' ') + 1).trim(); // task description


            // CARRY OUT TASK COMMAND
            if (type.equals("list")) {

                System.out.println("List of tasks:");
                for (int i = 0; i < commandCounter; i++) {
                    Task currTask = tasksList[i];
                    System.out.println(i + 1 + "." + currTask.toString());
                }

            } else if (type.equals("unmark")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                Task curr = tasksList[index];
                curr.markAsNotDone();

            } else if (type.equals("mark")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                Task curr = tasksList[index];
                curr.markAsDone();

            } else if (type.equals("bye")) {
                break;
            } else if (type.equals("todo") || type.equals("deadline") || type.equals("event")) { //adding tasks

                if (description.trim().isEmpty() || description.equals("todo") || description.equals("deadline") || description.equals("event")) {
                    throw new EmptyTaskException("Task description cannot be empty!");
                }

                // CREATE NEW TASK IN ARRAY
                if (type.equals("todo")) { // todo task
                    tasksList[commandCounter] = new Todo(description);
                } else if (type.equals("deadline")) { // deadline task
                    String by = taskArr[1].substring(taskArr[1].indexOf("by") + 2).trim();
                    if (by.isEmpty()) { //empty deadline
                        throw new DeadlineTaskException("Add a deadline!");
                    }
                    tasksList[commandCounter] = new Deadline(description, by);

                } else { // event task, assume no invalid inputs and only 3 types of task
                    String from = taskArr[1].substring(taskArr[1].indexOf("from") + 4).trim();
                    String to = taskArr[2].substring(taskArr[2].indexOf("to") + 2).trim();
                    if (from.isEmpty() && to.isEmpty()) {
                        throw new EventTaskException("Add a start and end date/time!");
                    } else if (from.isEmpty()) {
                        throw new EventTaskException("Add a start date/time!");
                    } else if (to.isEmpty()) {
                        throw new EventTaskException("Add a end date/time!");
                    }
                    tasksList[commandCounter] = new Event(description, from, to);
                }

                System.out.println(tasksList[commandCounter].addTaskDisplay());
                commandCounter++;
                System.out.println("Now you have " + commandCounter + " tasks in the list.");

            } else {
                throw new InvalidTaskException("Invalid task!");
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
