package commands;

import tasks.todoList;
import ui.Ui;

/**
 * Consists of generic command that can be executed.
 * Each command must implement the execute method and specify whether it is an exit command.
 */

public abstract class Command {

    /**
     * Executes the command.
     *
     * @param toDo the to-do list on which the command operates.
     * @param ui the user interface used for interaction.
     */
    public abstract void execute(todoList toDo, Ui ui);

    /**
     * Checks whether the command will cause the application to exit.
     *
     * @return true if the command will exit the application, false otherwise.
     */
    public abstract boolean isExit();
}
