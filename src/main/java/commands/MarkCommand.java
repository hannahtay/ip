package commands;

import tasks.Task;
import tasks.todoList;
import ui.Ui;

/**
 * Represents the command to mark a task as done.
 */
public class MarkCommand extends Command {
    private int taskNumber;

    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(todoList toDo, Ui ui){
        toDo.markTaskAsDone(taskNumber);
        Task task = toDo.getTask(taskNumber);
        System.out.println("Marked > " + task.getDescription() + " < as done!");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
