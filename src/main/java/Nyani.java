import java.util.Scanner;

public class Nyani {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sysMsgs systemOut = new sysMsgs();
        systemOut.showIntro();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("list")) {
                systemOut.listMsg();
            }
            else if (input.equalsIgnoreCase("bye")) {
               systemOut.exitMsg();
                break;
            } else {
                System.out.println("──────────୨ৎ──────────");
                System.out.println(input);
                System.out.println("──────────୨ৎ──────────");
            }
        }
        sc.close();
    }


}
