import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    protected LocalDate date;
    protected LocalDateTime dateTime;
    private boolean hasTime;
    protected String by;

    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        try {
            this.dateTime = LocalDateTime.parse(by, DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"));
            this.hasTime = true;
            this.by = by;
        } catch (DateTimeParseException e1) {
            try {
                this.date = LocalDate.parse(by, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                this.hasTime = false;
                this.by = by;
            } catch (DateTimeParseException e2) {
                throw new DeadlineTaskException("Invalid date/time format! Use dd-MM-yyyy or dd-MM-yyyy HHmm!");
            }
        }
    }

    public boolean hasTime() {
        return this.hasTime;
    }

    private String deadlineToString() {
        if (hasTime) {
            return this.dateTime.format(DateTimeFormatter.ofPattern("dd MMM yy hhmma"));
        } else {
            return this.date.format(DateTimeFormatter.ofPattern("dd MMM yy"));
        }
    }

    public String toSaveString() {
        return "D | " + (this.isDone? "1" : "0") + " | " + this.getDescription() + " | " + this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadlineToString() + ")";
    }
}
