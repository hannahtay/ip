import java.io.IOException;
import java.util.Scanner;

public class Nyani {
    public static void main(String[] args) throws NyaniException {
        Scanner sc = new Scanner(System.in);
        sysMsgs systemOut = new sysMsgs();
        systemOut.showIntro();
        todoList toDo = new todoList();

        while (true) {
            String input = sc.nextLine();
            try {
                //todoLIST
                if (input.equals("list")) {
                    toDo.showTasks();
                } else if (input.startsWith("mark ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(5).trim());
                        toDo.markTaskAsDone(taskNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task number :(");
                    }
                } else if (input.equals("help")) {
                    systemOut.commands();
                } else if (input.startsWith("unmark ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim());
                        toDo.markTaskAsNotDone(taskNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task number :(");
                    }

                    //DEADLINE
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ", 2);
                    if (parts.length == 2) {
                        toDo.addTask(new Deadline(parts[0], parts[1]));
                    } else {
                        throw new NyaniException("wrong format! try deadline [task] /by [date/time]!");
                    }
                } else if (input.startsWith("event ")) {
                    String[] fromPart = input.substring(6).split(" /from ", 2);
                    if (fromPart.length == 2) {
                        String[] toPart = fromPart[1].split("/to ", 2);
                        if (toPart.length == 2) {
                            toDo.addTask(new Event(fromPart[0], toPart[0], toPart[1]));
                        } else {
                            throw new NyaniException("wrong format! try event /from [date/time] /to [date/time]!");
                        }
                    } else {
                        throw new NyaniException("wrong format! try event /from [date/time] /to [date/time]!");
                    }
                } else if (input.equalsIgnoreCase("bye")) {
                    systemOut.exitMsgs();
                    break;
                } else if (input.startsWith("todo")) {
                    String taskDescription = input.substring(4).trim();
                    if (taskDescription.isEmpty()) {
                        throw new NyaniException("Type something to do!");
                    }
                    toDo.addTask(new ToDo(taskDescription));
                } else {
                    throw new NyaniException("Nyani does not understand :(");
                }
            } catch (NyaniException e) {
                e.printWithDivider();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }


}
