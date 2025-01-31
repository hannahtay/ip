import java.util.ArrayList;
import java.util.List;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
       isDone = true;
    }

    public void markNotDone() {
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return (isDone ? "[✮] " : "[ ] ") + description;
    }
}

public class todoList {
    private List<Task> tasks;
    public todoList() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(String taskDescription) {
        tasks.add(new Task(taskDescription));
        System.out.println("\uD83C\uDF53 Added! > " + taskDescription + " <");
    }

    public void markTaskAsDone(int taskNumber) {
        if (taskNumber > tasks.size() || taskNumber <= 0) {
            System.out.println("There's no such task!");
        } else {
            Task task = tasks.get(taskNumber - 1);
            task.markDone();
            System.out.println("\uD83C\uDF53 Marked > " + task.getDescription() + " < as done!");
        }
    }

    public void markTaskAsNotDone(int taskNumber) {
        if (taskNumber > tasks.size() || taskNumber <= 0) {
            System.out.println("There's no such task!");
        } else {
            Task task = tasks.get(taskNumber - 1);
            task.markNotDone();
            System.out.println("\uD83C\uDF53 Unmarked > " + task.getDescription() + " < as done!");
        }
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

