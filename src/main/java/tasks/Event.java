package tasks;

/**
 * tasks.Event class representing a task with a time window.
 */
public class Event extends Task {
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