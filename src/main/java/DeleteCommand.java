public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        Task t = tasks.getTask(index);
        tasks.removeTask(index);
        ui.showMessage("Ok, I've removed this task:\n" + t.toString());
        ui.showMessage("There are " + tasks.getSize() + " remaining tasks.");
        storage.saveTasks(tasks);
    }
}
