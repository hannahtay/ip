package commands;

import tasks.todoList;
import ui.Ui;

/**
 * Represents the command to exit the application.
 */
public class ExitCommand extends Command {
    @Override
    public void execute(todoList toDo, Ui ui){

    }

    @Override
    public boolean isExit() {
        return true;
    }
}