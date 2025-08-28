import javax.xml.xpath.XPathEvaluationResult;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Khat {

    public static void main(String[] args) {

        Storage storage = new Storage("./data/KhatTasks.txt");
        TaskList tasksList = storage.loadTasks();
        Ui ui = new Ui();

        ui.showWelcome();

        while (true) {
            String command = ui.readCommand(); // task description with type
            String type = Parser.getType(command); // type of task/ mark/unmark/delete/list/bye/date
            String description = Parser.getDescription(command);

            // CARRY OUT TASK COMMAND
            if (type.equals("list")) {
                tasksList.getTaskList();
            } else if (type.equals("bye")) { //close chatbot
                break;
            } else if (type.equals("unmark")) { //mark task as incomplete
                Task curr = tasksList.getTask(Parser.getIndex(command));
                curr.markAsNotDone();

            } else if (type.equals("mark")) { //mark task as complete
                Task curr = tasksList.getTask(Parser.getIndex(command));
                curr.markAsDone();

            } else if (type.equals("delete")) {
                tasksList.removeTask(Parser.getIndex(command));

            } else if (type.equals("date")) { //shows deadline tasks on specified date
                try {
                    LocalDate date = Parser.parseDate(description);
                    tasksList.printTasksOnDate(date);
                } catch (DateTimeParseException e) {
                    throw new KhatException("Invalid command! Please use dates in the format dd-MM-yyyy!");
                }

            } else if (type.equals("todo") || type.equals("deadline") || type.equals("event")) { //adding tasks

                // CREATE NEW TASK IN ARRAY
                if (type.equals("todo")) { // todo task
                    Task t = new Todo(description, false);
                    tasksList.addTask(t);

                } else if (type.equals("deadline")) { // deadline task
                    String by = Parser.getDeadline(command);
                    Task t = new Deadline(description, false, by);
                    tasksList.addTask(t);

                } else {
                    String from = Parser.getFrom(command);
                    String to = Parser.getTo(command);
                    Task t = new Event(description, false, from, to);
                    tasksList.addTask(t);
                }

            } else {
                throw new KhatException("Invalid task!");
            }
        }
        storage.saveTasks(tasksList);
        ui.showExit();
    }
}
