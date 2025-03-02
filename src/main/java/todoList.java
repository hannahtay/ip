import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Task class representing a generic task.
 */
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

    /**
     * Provides a string representation of the task.
     *
     * @return String representation of the task.
     */
    public String toString() {
        return "[" + getType() + "]" + (isDone ? "[X] " : "[ ] ") + description;
    }
}

/**
 * ToDo class representing a task classified under 'to-do'.
 */
class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public String getType(){
        return "T";
    }
}

/**
 * Deadline class representing a task with a deadline.
 */
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

/**
 * Event class representing a task with a time window.
 */
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

/**
 * Class managing the list of tasks in the to-do list.
 */
public class todoList {
    private List<Task> tasks;
    public todoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the to-do list.
     *
     * @param task the task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the to-do list by its task number.
     *
     * @param taskNumber the task number to delete.
     */
    public void deleteTask(int taskNumber) {
            if (taskNumber <= 0 || taskNumber > tasks.size()) {
                System.out.println("Invalid task number!");
            } else {
                Task removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Removed! > " + removedTask + " <");
                System.out.println("You have " + tasks.size() + " task(s) left!");
            }
    }

    /**
     * Marks a task as done based on its task number.
     *
     * @param taskNumber the task number to mark as done.
     */
    public void markTaskAsDone(int taskNumber) {
        if (taskNumber > tasks.size() || taskNumber <= 0) {
            System.out.println("There's no such task!");
        } else {
            Task task = tasks.get(taskNumber - 1);
            task.markDone();
        }
    }

    /**
     * Marks a task as not done based on its task number.
     *
     * @param taskNumber the task number to mark as not done.
     */
    public void markTaskAsNotDone(int taskNumber) {
        if (taskNumber > tasks.size() || taskNumber <= 0) {
            System.out.println("There's no such task!");
        } else {
            Task task = tasks.get(taskNumber - 1);
            task.markNotDone();
        }
    }

    /**
     * Displays all tasks in the to-do list.
     */
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

    /**
     * Converts the tasks into strings suitable for saving.
     *
     * @return List of task strings.
     */
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

    /**
     * Gets a task based on its task number.
     *
     * @param taskNumber the task number to retrieve.
     * @return the task object at the given index, or null if invalid.
     */
    public Task getTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return null;  // Return null if the task number is out of range
        }
        return tasks.get(taskNumber - 1);  // Return the task at the given index (taskNumber - 1)
    }


}

