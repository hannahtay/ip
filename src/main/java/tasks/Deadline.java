package tasks;

/**
 * tasks.Deadline class representing a task with a deadline.
 */
public class Deadline extends Task {
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
