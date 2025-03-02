/**
 * Parses user input and returns the corresponding Command object.
 */

public class Parser {

    /**
     * Parses the input command string and returns the appropriate command.
     *
     * @param fullCommand the full command string entered by the user.
     * @return the corresponding Command object.
     * @throws NyaniException if the command is invalid or improperly formatted.
     */

    public static Command parse(String fullCommand) throws NyaniException {

        //Split the command into the command word and the arguments
        String[] words = fullCommand.split(" ", 2);
        String commandWord = words[0].toLowerCase();
        String argument = words.length > 1 ? words[1] : "";

        // Match the command with the appropriate case
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
           return parseDeadline(argument);
        case "event":
           return parseEvent(argument);
        case "bye":
            return new ExitCommand();
        case "help":
            return new HelpCommand();
        default:
            throw new NyaniException("Nyani doesn't understand " + commandWord);
        }
    }

        /**
         * Parses a deadline command and returns the corresponding command.
         *
         * @param argument the deadline command argument.
         * @return the AddCommand with a Deadline task.
         * @throws NyaniException if the deadline format is invalid.
         */
        private static Command parseDeadline(String argument) throws NyaniException {
            String[] deadlineParts = argument.split(" /by ", 2);
            if (deadlineParts.length < 2) {
                throw new NyaniException("Wrong format! Try: deadline [task] /by [date/time]!");
            }
            return new AddCommand(new Deadline(deadlineParts[0], deadlineParts[1]));
        }

        /**
         * Parses an event command and returns the corresponding command.
         *
         * @param argument the event command argument.
         * @return the AddCommand with an Event task.
         * @throws NyaniException if the event format is invalid.
         */
        private static Command parseEvent(String argument) throws NyaniException {
            String[] eventParts = argument.split(" /from | /to ", 3);
            if (eventParts.length < 3) {
                throw new NyaniException("Wrong format! Try: event /from [date/time] /to [date/time]!");
            }
            return new AddCommand(new Event(eventParts[0], eventParts[1], eventParts[2]));
        }
    }
