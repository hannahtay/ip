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

            else if (input.startsWith ("deadline ")) {
                String[] parts = input.substring(9).split(" /by ", 2);
                if (parts.length == 2) {
                    toDo.addTask(new Deadline(parts[0], parts[1]));
                } else {
                    System.out.println("wrong format! try deadline [task] /by [date/time]!");
                }
            } else if (input.startsWith ("event ")) {
                String[] fromPart = input.substring(6).split(" /from ", 2);
                if (fromPart.length == 2) {
                    String[] toPart = fromPart[1].split("/to ", 2);
                    if (toPart.length == 2) {
                        toDo.addTask(new Event(fromPart[0], toPart[0], toPart[1]));
                    } else {
                        System.out.println("wrong format! try event /from [date/time] /to [date/time]!");
                    }
                } else {
                    System.out.println("wrong format! try event /from [date/time] /to [date/time]!");
                }
            }

            else if (input.equalsIgnoreCase("bye")) {
               systemOut.exitMsg();
                break;
            } else {
                toDo.addTask(new ToDo(input));
            }
        }
        sc.close();
    }


}
