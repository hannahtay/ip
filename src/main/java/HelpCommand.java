/**
 * Represents the command to show help information to the user.
 */
class HelpCommand extends Command {
    @Override
    public void execute(todoList toDo, Ui ui){
        ui.showHelpMsg();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}