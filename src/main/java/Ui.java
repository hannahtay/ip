/**
 * Ui class handles displaying system messages to the user.
 */
public class Ui {

    /**
     * Displays a divider line to the console.
     */
    public static void showDivider() {
        System.out.println("────────────────────");
    }

    /**
     * Displays an introductory message when the program starts.
     */
    public void showIntro() {
        String logo =
                "     ^,,,,^\n"
                        + "     ( O-O)\n"
                        + "     /^   >";
        System.out.println(logo);
        System.out.println("Hi there! I'm NYANI ^_^");
        System.out.println("What shall we do today?");
        System.out.println("Type 'help' to see all commands :)");
    }

    /**
     * Displays an exit message when the program exits.
     */
    public void showExitMsg() {
        showDivider();
        System.out.println("c U soon! :D ");
        showDivider();
    }

    /**
     * Displays the help message with a list of available commands.
     */
    public void showHelpMsg() {
        System.out.println("List of commands:");
        showDivider();
        System.out.println("list: shows todo list");
        System.out.println("mark: marks item as done");
        System.out.println("unmark: unmarks item as done");
        System.out.println("deadline: adds an item with specified deadline");
        System.out.println("          try deadline [task] /by [date/time]!");
        System.out.println("event: creates an event with specified timeline");
        System.out.println("       try event /from [date/time] /to [date/time]!");
        System.out.println("find: finds the task with your specified keyword");
        System.out.println("Type <bye> to exit & save your list!");
        showDivider();
    }
}