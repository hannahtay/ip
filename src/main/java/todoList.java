import java.util.ArrayList;
import java.util.List;

abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }


    public void markDone() { isDone = true; }

    public void markNotDone() {
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public abstract String getType();

    public String toString() {
        return "[" + getType() + "]" + (isDone ? "[✮] " : "[ ] ") + description;
    }
}

class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public String getType(){
        return "T";
    }
}

class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String getType() {
        return "D";
    }

    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }
}

class Event extends Task {
    private String start;
    private String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }
    public String getType() {
        return "E";
    }
    public String toString() {
        return super.toString() + " (from: " + start + " to: " + end + ")";
    }
}

public class todoList {
    private List<Task> tasks;
    public todoList() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("\uD83C\uDF53 Added! > " + task + " <");
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

