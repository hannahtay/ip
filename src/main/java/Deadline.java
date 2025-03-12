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
