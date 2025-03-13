package tasks;

/**
 * tasks.ToDo class representing a task classified under 'to-do'.
 */
public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public String getType(){
        return "T";
    }
}
