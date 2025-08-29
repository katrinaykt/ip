package khat.command;

import khat.exception.KhatException;
import khat.storage.Storage;
import khat.task.Task;
import khat.task.TaskList;
import khat.ui.Ui;

public class MarkCommand extends Command {

    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        try {
            Task curr = tasks.getTask(index);
            curr.markAsDone();
            ui.showMessage("Nice! I've marked this task as done:\n" + curr);
        } catch (IndexOutOfBoundsException e) {
            ui.showMessage("This task doesn't exist!");
        }
    }
}
