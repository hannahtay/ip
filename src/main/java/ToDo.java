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
