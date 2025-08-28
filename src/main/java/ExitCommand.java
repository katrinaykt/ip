public class ExitCommand extends Command {

    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        storage.saveTasks(tasks);
        ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
