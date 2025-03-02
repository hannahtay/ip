/**
 * Custom exception class for Nyani.
 */
public class NyaniException extends Exception {

    /**
     * Constructor to initialize the exception with a message.
     *
     * @param message The message to be displayed with the exception.
     */
    public NyaniException(String message) {
        super(message);
    }

    /**
     * Prints the exception message along with a divider for better readability.
     */
    public void printWithDivider() {
        Ui ui = new Ui();
        ui.showDivider();
        System.out.println(super.getMessage());
        ui.showDivider();
    }
}
