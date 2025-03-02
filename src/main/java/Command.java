/**
 * Consists of generic command that can be executed.
 * Each command must implement the execute method and specify whether it is an exit command.
 */

abstract class Command {

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

/**
 * Represents the command to mark a task as done.
 */
class MarkCommand extends Command {
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

/**
 * Represents the command to unmark a task as not done.
 */
class UnmarkCommand extends Command {
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

/**
 * Represents the command to add a new task to the to-do list.
 */
class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(todoList toDo, Ui ui){
        toDo.addTask(task);
        System.out.println("Added > " + task + " < !");
    }
    @Override
    public boolean isExit() {
        return false;
    }
}

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