import java.util.ArrayList;
import java.util.List;

public class todoList {
    private List<String> tasks;
    public todoList() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("\uD83C\uDF53 Added! > " + task + " <");
    }
    public void showTasks() {
        if (tasks.isEmpty()){
            System.out.println("──────────୨ৎ──────────");
            System.out.println("Time to chill ₊˚⊹ ᰔ");
            System.out.println("──────────୨ৎ──────────");
        } else {
            System.out.println("──────────୨ৎ──────────");
            System.out.println("To-do!");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("──────────୨ৎ──────────");
        }
    }

}

