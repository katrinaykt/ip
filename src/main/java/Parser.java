import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {

    public static String getType(String command) {
        return command.split(" ")[0];
    }

    public static String getDescription(String command) {
        String description = command.split("/")[0]
                .substring(command.split("/")[0].indexOf(' ') + 1).trim();
        if (description.isEmpty()) {
            throw new EmptyTaskException("Task description cannot be empty!");
        }
        return description;
    }

    public static int getIndex(String command) {
        return Integer.parseInt(command.split(" ")[1]) - 1;
    }

    public static String getDeadline(String command) {
        String descriptionArr[] = command.split("/by"); // [0] -> type, [1] -> by
        if (descriptionArr.length < 2) {
            throw new DeadlineTaskException("Add a deadline task in the format 'deadline [task] /by [deadline]!'");
        }
        return descriptionArr[1].trim();
    }

    public static String getFrom(String command) {
        String commandArr[] = command.split("/from|/to"); // [0] -> type, [1] -> from, [2] -> to
        if (commandArr.length < 3) {
            throw new EventTaskException("Add an event task in the format 'event [task] /from [start] /to [end]!'");
        }
        return commandArr[1].trim();
    }

    public static String getTo(String command) {
        String commandArr[] = command.split("/from|/to"); // [0] -> type, [1] -> from, [2] -> to
        if (commandArr.length < 3) {
            throw new EventTaskException("Add an event task in the format 'event [task] /from [start] /to [end]!'");
        }
        return commandArr[2].trim();
    }

    public static LocalDate parseDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
