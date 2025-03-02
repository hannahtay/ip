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
        return "[" + getType() + "]" + (isDone ? "[X] " : "[ ] ") + description;
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
    String deadline;

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
    String start;
    String end;

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
    }

    public void deleteTask(int taskNumber) {
            if (taskNumber <= 0 || taskNumber > tasks.size()) {
                System.out.println("Invalid task number!");
            } else {
                Task removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Removed! > " + removedTask + " <");
                System.out.println("You have " + tasks.size() + " task(s) left!");
            }
    }

    public void markTaskAsDone(int taskNumber) {
        if (taskNumber > tasks.size() || taskNumber <= 0) {
            System.out.println("There's no such task!");
        } else {
            Task task = tasks.get(taskNumber - 1);
            task.markDone();
        }
    }

    public void markTaskAsNotDone(int taskNumber) {
        if (taskNumber > tasks.size() || taskNumber <= 0) {
            System.out.println("There's no such task!");
        } else {
            Task task = tasks.get(taskNumber - 1);
            task.markNotDone();
        }
    }

    public void showTasks() {
        if (tasks.isEmpty()){
            System.out.println("────────────────────");
            System.out.println("Time to chill !");
            System.out.println("────────────────────");
        } else {
            System.out.println("────────────────────");
            System.out.println("To-do!");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("────────────────────");
        }
    }

    public List<String> getTaskStrings() {
        List<String> taskStrings = new ArrayList<>();
        for (Task task : tasks) {
            if (task instanceof ToDo) {
                taskStrings.add((task.isDone() ? "[X]" : "[ ]") + "TODO: " + task.getDescription());
            } else if (task instanceof Deadline) {
                Deadline deadline = (Deadline) task;
                taskStrings.add((task.isDone() ? "[X]" : "[ ]") + "DEADLINE (by: " + deadline.deadline + ") | " + task.getDescription());
            } else if (task instanceof Event) {
                Event event = (Event) task;
                taskStrings.add((task.isDone() ? "[X]" : "[ ]") + "EVENT (from: " + event.start + " to: " + event.end + ") | " + task.getDescription());
            }
        }
        return taskStrings;
    }

    public Task getTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return null;  // Return null if the task number is out of range
        }
        return tasks.get(taskNumber - 1);  // Return the task at the given index (taskNumber - 1)
    }

    public void findTask(String keyword){
        boolean found = false;
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Task not found!");
        }
    }
}

