package commands;

import tasks.todoList;
import ui.Ui;

/**
 * Represents the command to show help information to the user.
 */
public class HelpCommand extends Command {
    @Override
    public void execute(todoList toDo, Ui ui){
        ui.showHelpMsg();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}