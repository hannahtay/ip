abstract class Command {
    public abstract void execute(todoList toDo, Ui ui);
    public abstract boolean isExit();
}

class ListCommand extends Command {
    @Override
    public void execute(todoList toDo, Ui ui){
        toDo.showTasks();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

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

class ExitCommand extends Command {
    @Override
    public void execute(todoList toDo, Ui ui){

    }

    @Override
    public boolean isExit() {
        return true;
    }
}

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