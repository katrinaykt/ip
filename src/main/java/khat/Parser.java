package khat;

import khat.command.*;
import khat.exception.DeadlineTaskException;
import khat.exception.EmptyTaskException;
import khat.exception.EventTaskException;
import khat.exception.KhatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {

    public enum CommandType {
        LIST, BYE, MARK, UNMARK, DELETE, DATE, Find, TODO, DEADLINE, EVENT, UNKNOWN
    }

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

    public static CommandType getCommandType(String command) {
        String type = getType(command);
        return switch (type) {
            case "list" -> CommandType.LIST;
            case "bye" -> CommandType.BYE;
            case "mark" -> CommandType.MARK;
            case "unmark" -> CommandType.UNMARK;
            case "delete" -> CommandType.DELETE;
            case "date" -> CommandType.DATE;
            case "find" -> CommandType.Find;
            case "todo" -> CommandType.TODO;
            case "deadline" -> CommandType.DEADLINE;
            case "event" -> CommandType.EVENT;
            default -> CommandType.UNKNOWN;
        };
    }

    public static Command parse(String command) throws KhatException {
        CommandType type = getCommandType(command);
        String description = getDescription(command);
        return switch (type) {
            case LIST -> new ListCommand();
            case BYE -> new ExitCommand();
            case MARK -> new MarkCommand(getIndex(command));
            case UNMARK -> new UnmarkCommand(getIndex(command));
            case DELETE -> new DeleteCommand(getIndex(command));
            case DATE -> new DateCommand(description);
            case Find -> new FindCommand(description);
            case TODO -> new AddCommand(description, "todo");
            case DEADLINE -> new AddCommand(description, "deadline", getDeadline(command));
            case EVENT -> new AddCommand(description, "event", getFrom(command), getTo(command));
            default -> throw new KhatException("Invalid command!");
        };
    }

    public static int getIndex(String command) {
        return Integer.parseInt(command.split(" ")[1]) - 1;
    }

    public static String getDeadline(String command) {
        String[] descriptionArr = command.split("/by"); // [0] -> type, [1] -> by
        if (descriptionArr.length < 2) {
            throw new DeadlineTaskException("Add a deadline task in the format 'deadline [task] /by [deadline]!'");
        }
        return descriptionArr[1].trim();
    }

    public static String getFrom(String command) {
        String[] commandArr = command.split("/from|/to"); // [0] -> type, [1] -> from, [2] -> to
        if (commandArr.length < 3) {
            throw new EventTaskException("Add an event task in the format 'event [task] /from [start] /to [end]!'");
        }
        return commandArr[1].trim();
    }

    public static String getTo(String command) {
        String[] commandArr = command.split("/from|/to"); // [0] -> type, [1] -> from, [2] -> to
        if (commandArr.length < 3) {
            throw new EventTaskException("Add an event task in the format 'event [task] /from [start] /to [end]!'");
        }
        return commandArr[2].trim();
    }

    public static LocalDate parseDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
