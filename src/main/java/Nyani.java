//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Nyani {

    public static void main(String[] args) throws NyaniException {
        Scanner sc = new Scanner(System.in);
        sysMsgs systemOut = new sysMsgs();
        systemOut.showIntro();
        todoList toDo = new todoList();

        SaveDataHandler.readSaveData(toDo);

        while(true) {
            String input = sc.nextLine();

            try {
                if (input.equals("list")) {
                    toDo.showTasks();
                } else if (input.startsWith("mark ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(5).trim());
                        toDo.markTaskAsDone(taskNumber);
                        Task task = toDo.getTask(taskNumber);
                        System.out.println("\uD83C\uDF53 Marked > " + task.getDescription() + " < as done!");
                    } catch (NumberFormatException var8) {
                        System.out.println("Invalid task number :(");
                    }
                } else if (input.equals("help")) {
                    systemOut.commands();
                } else if (input.startsWith("unmark ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim());
                        toDo.markTaskAsNotDone(taskNumber);
                        Task task = toDo.getTask(taskNumber);
                        System.out.println("\uD83C\uDF53 Unmarked > " + task + " < as done!");
                    } catch (NumberFormatException var7) {
                        System.out.println("Invalid task number :(");
                    }
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ", 2);
                    if (parts.length != 2) {
                        throw new NyaniException("wrong format! try deadline [task] /by [date/time]!");
                    }

                    Deadline deadline = new Deadline(parts[0], parts[1]);
                    toDo.addTask(deadline);
                    System.out.println("\uD83C\uDF53 Added! > " + deadline + " <");
                } else if (input.startsWith("event ")) {
                    String[] fromPart = input.substring(6).split(" /from ", 2);
                    if (fromPart.length != 2) {
                        throw new NyaniException("wrong format! try event /from [date/time] /to [date/time]!");
                    }

                    String[] toPart = fromPart[1].split("/to ", 2);
                    if (toPart.length != 2) {
                        throw new NyaniException("wrong format! try event /from [date/time] /to [date/time]!");
                    }

                    Event event = new Event(fromPart[0], toPart[0], toPart[1]);
                    toDo.addTask(event);
                    System.out.println("\uD83C\uDF53 Added! > " + event + " <");
                } else {
                    if (input.equalsIgnoreCase("bye")) {
                        SaveDataHandler.saveData(toDo);
                        systemOut.exitMsgs();
                        break;
                    }

                    if (!input.startsWith("todo")) {
                        throw new NyaniException("Nyani does not understand :(");
                    }

                    String taskDescription = input.substring(4).trim();
                    if (taskDescription.isEmpty()) {
                        throw new NyaniException("Type something to do!");
                    }
                    ToDo toDoTask = new ToDo(taskDescription);
                    toDo.addTask(toDoTask);
                    System.out.println("\uD83C\uDF53 Added! > " + toDoTask + " <");
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
