package khat;

import khat.command.Command;
import khat.exception.KhatException;
import khat.storage.Storage;
import khat.task.TaskList;
import khat.ui.Ui;

import java.io.FileNotFoundException;

public class Khat {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Khat(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String command = ui.readCommand();
                ui.showDivider();
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (KhatException e) {
                ui.showMessage(e.getMessage());
            } finally {
                ui.showDivider();
            }
        }
    }

    public static void main(String[] args) {
        new Khat("./data/KhatTasks.txt").run();
    }
}
