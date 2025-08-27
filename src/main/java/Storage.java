import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private final File KhatTasks;

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

    public TaskList loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        if (!KhatTasks.exists()) {
            return new TaskList(tasks);
        }
        try (Scanner scanner = new Scanner(KhatTasks)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.parse(line);
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return new TaskList(tasks);
    }

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
