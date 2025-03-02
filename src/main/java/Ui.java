public class Ui {

    public static void showDivider() {
        System.out.println("────────────────────");
    }

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

    public void showExitMsg() {
        showDivider();
        System.out.println("c U soon! :D ");
        showDivider();
    }

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
        System.out.println("Type <bye> to exit & save your list!");
        showDivider();
    }
}