package khat.command;

import khat.exception.KhatException;
import khat.storage.Storage;
import khat.task.TaskList;
import khat.ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        ui.showTasks(tasks.getAllTasks());
    }
}
