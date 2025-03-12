/**
 * Represents the command to delete a task from the to-do list.
 */
class DeleteCommand extends Command {
    private int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(todoList toDo, Ui ui){
        toDo.deleteTask(taskNumber);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
