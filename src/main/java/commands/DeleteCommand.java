package commands;

import tasks.Task;
import tasks.todoList;
import ui.Ui;

/**
 * Represents the command to delete a task from the to-do list.
 */
public class DeleteCommand extends Command {
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
