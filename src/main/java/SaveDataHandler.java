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

    static void readSaveData(todoList toDo) {
        String home = System.getProperty("user.home");
        Path saveFilePath = Paths.get(home, "Documents", "Nyani.txt");

        if (Files.exists(saveFilePath)) {
            try {
                List<String> lines = Files.readAllLines(saveFilePath);
                System.out.println("Loading tasks...");
                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Read failed :(");
            }
        } else {
            System.out.println("Nyani doesn't have any files to read at the moment...");
                }
            }
        }
