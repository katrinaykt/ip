import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateCommand extends Command {

    private String dateString;

    public DateCommand(String date) {
        this.dateString = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        try {
            LocalDate date = Parser.parseDate(dateString);
            tasks.printTasksOnDate(date);
        } catch (DateTimeParseException e) {
            throw new KhatException("Invalid command! Please use dates in the format dd-MM-yyyy!");
        }
    }
}
