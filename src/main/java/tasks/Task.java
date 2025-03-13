package tasks;

/**
 * Abstract tasks.Task class representing a generic task.
 */
public abstract class Task {
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