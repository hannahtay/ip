public class sysMsgs {

    public static void divider() {
        System.out.println("──────────୨ৎ──────────");
    }

    public void showIntro() {
        String logo =
                "     /ᐠ,,,,∧\n"
                        + "     (֊⎚-⎚)\n"
                        + "     /⌒   づ\uD83D\uDCD7";
        System.out.println(logo);
        System.out.println("Hi there! I'm NYANI ^_^");
        System.out.println("What shall we do today?");
        System.out.println("Type 'help' to see all commands :)");
    }

    public void exitMsgs() {
        divider();
        System.out.println("c U soon! ꈍ ꈍ");
        divider();
    }

    public void commands() {
        System.out.println("List of commands:");
        divider();
        System.out.println("list: shows todo list");
        System.out.println("mark: marks item as done");
        System.out.println("unmark: unmarks item as done");
        System.out.println("deadline: adds an item with specified deadline");
        System.out.println("          try deadline [task] /by [date/time]!");
        System.out.println("event: creates an event with specified timeline");
        System.out.println("       try event /from [date/time] /to [date/time]!");
        System.out.println("bye: exits the program");
        divider();
    }
}