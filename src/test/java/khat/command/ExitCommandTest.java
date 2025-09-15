package khat.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import khat.exception.KhatException;
import khat.storage.Storage;
import khat.task.TaskList;
import khat.ui.Ui;

public class ExitCommandTest {

    @Test
    void execute_exitCommand_savesTasksAndShowsExit() {
        TaskList tasks = new TaskList();
        // Mock Ui
        Ui ui = new Ui() {
            private boolean exitShown = false;
            @Override
            public void showExit() {
                exitShown = true;
            }
        };
        // Mock Storage
        Storage storage = new Storage("test/test.txt") {
            private boolean saved = false;
            @Override
            public void saveTasks(TaskList t) throws KhatException {
                saved = true;
            }
        };
        ExitCommand cmd = new ExitCommand();
        assertDoesNotThrow(() -> cmd.execute(tasks, ui, storage));
    }

    @Test
    void isExit_exitCommand_returnsTrue() {
        ExitCommand cmd = new ExitCommand();
        assertTrue(cmd.isExit());
    }
}
