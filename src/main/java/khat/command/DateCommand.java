package khat.command;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import khat.Parser;
import khat.exception.KhatException;
import khat.storage.Storage;
import khat.task.*;
import khat.ui.Ui;

public class DateCommand extends Command {

    private String dateString;

    public DateCommand(String date) {
        this.dateString = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KhatException {
        try {
            LocalDate date = Parser.parseDate(dateString);
            TaskList filteredTasks = tasks.getTasksOnDate(date);
            ui.showTasksOnDate(filteredTasks, date);
        } catch (DateTimeParseException e) {
            throw new KhatException("Invalid command! Please use dates in the format dd-MM-yyyy!");
        }
    }
}
