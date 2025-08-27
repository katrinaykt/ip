import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Khat {
    public static void main(String[] args) {

        Scanner userInputScanner = new Scanner(System.in);
        Storage storage = new Storage("./data/KhatTasks.txt");
        TaskList tasksList = storage.loadTasks();

        System.out.println("Hello! I'm Khat.\nWhat can I do for you?");

        while (true) {
            String command = userInputScanner.nextLine(); // task description with type
            String[] taskArr = command.split("/"); // idx 0 - description, 1 - by/from, 2 - to
            String type = command.split(" ")[0]; // type of task/ mark/unmark
            String description = taskArr[0].substring(taskArr[0].indexOf(' ') + 1).trim(); // task description


            // CARRY OUT TASK COMMAND
            if (type.equals("list")) {
                tasksList.getList();
            } else if (type.equals("bye")) { //close chatbot
                break;
            } else if (type.equals("unmark")) { //mark task as incomplete
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                Task curr = tasksList.getTask(index);
                curr.markAsNotDone();

            } else if (type.equals("mark")) { //mark task as complete
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                Task curr = tasksList.getTask(index);
                curr.markAsDone();

            } else if (type.equals("delete")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                tasksList.removeTask(index);

            } else if (type.equals("date")) {
                try {
                    LocalDate date = LocalDate.parse(description, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    tasksList.printTasksOnDate(date);
                } catch (DateTimeParseException e) {
                    throw new InvalidTaskException("Please use dates in the format dd-MM-yyyy!");
                }

            } else if (type.equals("todo") || type.equals("deadline") || type.equals("event")) { //adding tasks

                if (description.trim().isEmpty() || description.equals("todo") || description.equals("deadline") || description.equals("event")) {
                    throw new EmptyTaskException("Task description cannot be empty!");
                }

                // CREATE NEW TASK IN ARRAY
                if (type.equals("todo")) { // todo task
                    Task t = new Todo(description, false);
                    tasksList.addTask(t);
                } else if (type.equals("deadline")) { // deadline task
                    String by = taskArr[1].substring(taskArr[1].indexOf("by") + 2).trim();
                    if (by.isEmpty()) { // empty deadline
                        throw new DeadlineTaskException("Add a deadline!");
                    }
                    Task t = new Deadline(description, false, by);
                    tasksList.addTask(t);

                } else {
                    String from = taskArr[1].substring(taskArr[1].indexOf("from") + 4).trim();
                    String to = taskArr[2].substring(taskArr[2].indexOf("to") + 2).trim();
                    if (from.isEmpty() && to.isEmpty()) {
                        throw new EventTaskException("Add a start and end date/time!");
                    } else if (from.isEmpty()) {
                        throw new EventTaskException("Add a start date/time!");
                    } else if (to.isEmpty()) {
                        throw new EventTaskException("Add a end date/time!");
                    }
                    Task t = new Event(description, false, from, to);
                    tasksList.addTask(t);
                }

            } else {
                throw new InvalidTaskException("Invalid task!");
            }
        }
        storage.saveTasks(tasksList);
        System.out.println("Bye. Hope to see you again soon!");
    }
}
