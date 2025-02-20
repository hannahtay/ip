import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.nio.file.Files;

public class SaveDataHandler {

    public static void saveData(todoList toDo) {
        String home = System.getProperty("user.home");

        Path saveFilePath = Paths.get(home, "Documents", "Nyani.txt");

        writeSaveData(saveFilePath, toDo.getTaskStrings());

        readSaveData(toDo);

    }


    private static void writeSaveData(Path path, List<String> tasks) {
        try {
            Files.write(path, tasks);
            System.out.println("Nyani will remember ur tasks for u!");
        } catch (IOException e) {
            System.err.println("Save failed :(");
        }
    }

    public static void readSaveData(todoList toDo) {
        String home = System.getProperty("user.home");
        Path saveFilePath = Paths.get(home, "Documents", "Nyani.txt");

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

                    String status = parts[0].trim();  // Status part: [✮] or [ ]
                    String taskInfo = parts[1].trim();  // Task info part: TODO
                    // Create tasks based on the type and description
                    if (taskInfo.startsWith("TODO:")) {
                        String description = taskInfo.substring(5).trim();
                        ToDo task = new ToDo(description);
                        if (status.equals("[X")) {
                            task.markDone();  // Mark as done if [✮]
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
                            task.markDone();  // Mark as done if [✮]
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
                            task.markDone();  // Mark as done if [✮]
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