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
        LIST, BYE, MARK, UNMARK, DELETE, DATE, TODO, DEADLINE, EVENT, UNKNOWN
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
        switch (type) {
            case "list": return CommandType.LIST;
            case "bye": return CommandType.BYE;
            case "mark": return CommandType.MARK;
            case "unmark": return CommandType.UNMARK;
            case "delete": return CommandType.DELETE;
            case "date": return CommandType.DATE;
            case "todo": return CommandType.TODO;
            case "deadline": return CommandType.DEADLINE;
            case "event": return CommandType.EVENT;
            default: return CommandType.UNKNOWN;
        }
    }

    public static Command parse(String command) throws KhatException {
        CommandType type = getCommandType(command);
        String description = getDescription(command);
        switch (type) {
            case LIST: return new ListCommand();
            case BYE: return new ExitCommand();
            case MARK: return new MarkCommand(getIndex(command));
            case UNMARK: return new UnmarkCommand(getIndex(command));
            case DELETE: return new DeleteCommand(getIndex(command));
            case DATE: return new DateCommand(description);
            case TODO: return new AddCommand(description, "todo");
            case DEADLINE: return new AddCommand(description, "deadline", getDeadline(command));
            case EVENT: return new AddCommand(description, "event", getFrom(command), getTo(command));
            default: throw new KhatException("Invalid command!");
        }
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
