/**
 * Represents the command to find tasks using user-specified keyword.
 */
class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(todoList toDo, Ui ui) {
        toDo.findTask(keyword);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}