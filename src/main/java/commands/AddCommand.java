package commands;
import tasks.todoList;
import tasks.Task;
import ui.Ui;

/**
 * Represents the command to add a new task to the to-do list.
 */
public class AddCommand extends Command {
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
