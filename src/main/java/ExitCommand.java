/**
 * Represents the command to exit the application.
 */
class ExitCommand extends Command {
    @Override
    public void execute(todoList toDo, Ui ui){

    }

    @Override
    public boolean isExit() {
        return true;
    }
}