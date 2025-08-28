import java.time.LocalDate;

public class AddCommand extends Command {

    private String type;
    private String description;
    private String by; //deadline
    private String from; //event
    private String to; //event

    //todo, deadline and event tasks to add
    public AddCommand(String description, String type) {
        this.type = type;
        this.description = description;
        this.by = null;
        this.from = null;
        this.to = null;
    }

    public AddCommand(String description, String type, String by) {
        this.type = type;
        this.description = description;
        this.by = by;
        this.from = null;
        this.to = null;
    }

    public AddCommand(String description, String type, String from, String to) {
        this.type = type;
        this.description = description;
        this.by = null;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        Task t = switch (type) {
            case "todo" -> new Todo(description, false);
            case "deadline" -> new Deadline(description, false, by);
            case "event" -> new Event(description, false, from, to);
            default -> throw new KhatException("Invalid task!");
        };
        tasks.addTask(t);
        ui.showMessage("Got it. I've added this task:\n" + t);
        ui.showMessage("Now you have " + tasks.getSize() + " tasks in the list.");
        storage.saveTasks(tasks);
    }
}
