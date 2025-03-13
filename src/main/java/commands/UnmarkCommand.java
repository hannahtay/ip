package commands;

import tasks.Task;
import tasks.todoList;
import ui.Ui;

/**
 * Represents the command to unmark a task as not done.
 */
public class UnmarkCommand extends Command {
    private int taskNumber;

    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(todoList toDo, Ui ui){
        toDo.markTaskAsNotDone(taskNumber);
        Task task = toDo.getTask(taskNumber);
        System.out.println("Unmarked > " + task.getDescription() + " < as done!");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}