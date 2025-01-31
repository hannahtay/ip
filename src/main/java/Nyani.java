import java.util.Scanner;

public class Nyani {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sysMsgs systemOut = new sysMsgs();
        systemOut.showIntro();
        todoList toDo = new todoList();

        while (true) {
            String input = sc.nextLine();

            if (input.equals("list")) {
                toDo.showTasks();
            }
            else if (input.equalsIgnoreCase("bye")) {
               systemOut.exitMsg();
                break;
            } else {
                toDo.addTask(input);
            }
        }
        sc.close();
    }


}
