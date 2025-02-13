public class NyaniException extends Exception {
    public NyaniException(String message) {
        super(message);
    }

    public void printWithDivider() {
        sysMsgs systemOut = new sysMsgs();
        systemOut.divider();
        System.out.println(super.getMessage());
        systemOut.divider();
    }
}
