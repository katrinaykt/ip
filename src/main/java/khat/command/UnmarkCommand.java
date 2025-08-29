package khat.command;

import khat.exception.KhatException;
import khat.storage.Storage;
import khat.task.Task;
import khat.task.TaskList;
import khat.ui.Ui;

public class UnmarkCommand extends Command {

    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        try {
            Task curr = tasks.getTask(index);
            curr.markAsNotDone();
            ui.showMessage("Ok, I've marked this task as not done yet:\n" + curr);
        } catch (IndexOutOfBoundsException e) {
            ui.showMessage("This task doesn't exist!");
        }
    }
}
