package khat.storage;

import khat.Parser;
import khat.task.Task;
import khat.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading and saving tasks to the hard disk.
 */
public class Storage {

    private final File KhatTasks;

    /**
     * Constructs a Storage object with the given file path.
     * Creates the parent directory if it does not exist.
     *
     * @param path The file path for storing tasks.
     */
    public Storage(String path) {
        this.KhatTasks = new File(path);
        File parentDir = KhatTasks.getParentFile();
        if (!parentDir.exists()) {
            boolean created = parentDir.mkdirs();
            if (!created) {
                System.out.println("Error creating directory for tasks!");
            }
        }
    }

    /**
     * Loads tasks from the file.
     *
     * @return An ArrayList of tasks loaded from the file.
     * @throws FileNotFoundException If the file does not exist.
     */
    public ArrayList<Task> loadTasks() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        if (!KhatTasks.exists()) {
            return tasks;
        }
        try (Scanner scanner = new Scanner(KhatTasks)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Parser.parseTask(line);
                tasks.add(task);
            }
        }
        return tasks;
    }

    /**
     * Saves the given task list to the file.
     *
     * @param tasks The task list to save.
     */
    public void saveTasks(TaskList tasks) {
        try (FileWriter writer = new FileWriter(KhatTasks)) {
            for (Task task : tasks.getAllTasks()) {
                writer.write(task.toSaveString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

}
