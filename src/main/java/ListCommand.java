
/**
 * Represents the command to list all tasks in the to-do list.
 */
class ListCommand extends Command {

    /**
     * Executes the command to display the list of tasks.
     *
     * @param toDo the to-do list to show.
     * @param ui the user interface to display the tasks.
     */
    @Override
    public void execute(todoList toDo, Ui ui){
        toDo.showTasks();
    }

    /**
     * Returns false since this command doesn't exit the application.
     *
     * @return false, this command doesn't cause the application to exit.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}