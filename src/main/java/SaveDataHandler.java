import tasks.Deadline;
import tasks.Event;
import tasks.ToDo;
import tasks.todoList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

/**
 * Handles the saving and reading of tasks to/from a file.
 */
public class SaveDataHandler {

    // Specifies relative path to save in the repo
    private static final String SAVE_FILE_PATH = "data/Nyani.txt";

    /**
     * Saves the current task list to a file and then loads it.
     *
     * @param toDo the to-do list containing the tasks to save.
     */
    public static void saveData(todoList toDo) {

        Path saveFilePath = Paths.get(SAVE_FILE_PATH);

        try {
            Files.createDirectories(saveFilePath.getParent());
        } catch (IOException e) {
            System.err.println("Could not create directory.");
            return;
        }

        writeSaveData(saveFilePath, toDo.getTaskStrings());

        readSaveData(toDo);

    }

    /**
     * Writes the list of task strings to a file.
     *
     * @param path the path of the file to save the tasks to.
     * @param tasks the list of task strings to save.
     */
    private static void writeSaveData(Path path, List<String> tasks) {
        try {
            Files.write(path, tasks);
            System.out.println("Nyani will remember ur tasks for u!");
        } catch (IOException e) {
            System.err.println("Save failed :(");
        }
    }

    /**
     * Reads saved tasks from a file and adds them to the to-do list.
     *
     * @param toDo the to-do list to which the tasks will be added.
     */
    public static void readSaveData(todoList toDo) {
        Path saveFilePath = Paths.get(SAVE_FILE_PATH);

        if (Files.exists(saveFilePath)) {
            try {
                List<String> lines = Files.readAllLines(saveFilePath);
                System.out.println("Loading tasks...");

                for (String line : lines) {

                    // Print each line being processed
                    System.out.println(line);

                    // Split the line into status and the rest of the info
                    String[] parts = line.split("\\]", 2);
                    if (parts.length < 2) continue;  // If the line is not valid, skip

                    String status = parts[0].trim();  // Status part: [X] or [ ]
                    String taskInfo = parts[1].trim();  // tasks.Task info part: TODO
                    // Create tasks based on the type and description
                    if (taskInfo.startsWith("TODO:")) {
                        String description = taskInfo.substring(5).trim();
                        ToDo task = new ToDo(description);
                        if (status.equals("[X")) {
                            task.markDone();  // Mark as done if [X]
                        }
                        toDo.addTask(task);
                    } else if (taskInfo.startsWith("DEADLINE")) {
                        String[] deadlineParts = taskInfo.split("\\| ", 2);
                        String description = deadlineParts[1].trim();
                        String timeInfo = deadlineParts[0].trim();
                        String[] timeParts = timeInfo.split(" \\(by: ",2);
                        String deadline = timeParts[1].substring(0,timeParts[1].length()- 1).trim();

                        Deadline task = new Deadline(description, deadline);
                        if (status.equals("[X")) {
                            task.markDone();  // Mark as done if [X]
                        }
                        toDo.addTask(task);
                    } else if (taskInfo.startsWith("EVENT")) {
                        String[] eventParts = taskInfo.split("\\| ", 2); //splits at desc
                        String description = eventParts[1].trim();
                        String timeInfo = eventParts[0].trim();

                        String[] timeParts = timeInfo.split(" \\(from: ", 2);
                        String[] times = timeParts[1].split(" to: ", 2);
                        String start = times[0].trim();
                        String end = times[1].substring(0, times[1].length() - 1).trim();
                        Event task = new Event(description, start, end);
                        if (status.equals("[X")) {
                            task.markDone();  // Mark as done if [X]
                        }
                        toDo.addTask(task);
                    }
                }
            } catch (IOException e) {
                System.err.println("Read failed :(");
            }
        } else {
            System.out.println("Nyani doesn't have any files to read at the moment...");
        }
    }
}