public class Parser {
    public static Command parse(String fullCommand) throws NyaniException {
        String[] words = fullCommand.split(" ",2);
        String commandWord = words[0].toLowerCase();
        String argument = words.length > 1 ? words[1] : "";

        switch (commandWord) {
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(Integer.parseInt(argument));
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(argument));
        case "delete":
            return new DeleteCommand(Integer.parseInt(argument));
        case "todo":
            return new AddCommand(new ToDo(argument));
        case "deadline":
            String[] deadlineParts = argument.split(" /by ", 2);
            if (deadlineParts.length < 2) {
                throw new NyaniException("wrong format! Try: deadline [task] /by [date/time]!");
            }
            return new AddCommand(new Deadline(deadlineParts[0], deadlineParts[1]));
            case "event":
            String[] eventParts = argument.split(" /from | /to ", 3);
            if (eventParts.length < 3) {
                throw new NyaniException("wrong format! Try: event /from [date/time] /to [date/time]!");
            }
                return new AddCommand(new Event(eventParts[0], eventParts[1], eventParts[2]));
        case "bye":
            return new ExitCommand();
            case "help":
                return new HelpCommand();
                default: throw new NyaniException("Nyani doesn't understand " + commandWord);
            }

        }
    }
