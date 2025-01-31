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
            } else if (input.startsWith("mark ")) {
                try {
                    int taskNumber = Integer.parseInt(input.substring(5).trim());
                    toDo.markTaskAsDone(taskNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid task number :(");
                }
            }

            else if (input.startsWith("unmark ")) {
                try {
                    int taskNumber = Integer.parseInt(input.substring(7).trim());
                    toDo.markTaskAsNotDone(taskNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid task number :(");
                }
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
