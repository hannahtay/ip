public class NyaniException extends Exception {

    public NyaniException(String message) {
        super(message);
    }

    public void printWithDivider() {
        Ui systemOut = new Ui();
        systemOut.showDivider();
        System.out.println(super.getMessage());
        systemOut.showDivider();
    }
}
