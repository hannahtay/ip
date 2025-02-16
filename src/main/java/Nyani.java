//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Nyani {
    public Nyani() {
    }

    public static void main(String[] args) throws NyaniException {
        Scanner sc = new Scanner(System.in);
        sysMsgs systemOut = new sysMsgs();
        systemOut.showIntro();
        todoList toDo = new todoList();

        while(true) {
            String input = sc.nextLine();

            try {
                if (input.equals("list")) {
                    toDo.showTasks();
                } else if (input.startsWith("mark ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(5).trim());
                        toDo.markTaskAsDone(taskNumber);
                    } catch (NumberFormatException var8) {
                        System.out.println("Invalid task number :(");
                    }
                } else if (input.equals("help")) {
                    systemOut.commands();
                } else if (input.startsWith("unmark ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim());
                        toDo.markTaskAsNotDone(taskNumber);
                    } catch (NumberFormatException var7) {
                        System.out.println("Invalid task number :(");
                    }
                } else if (input.startsWith("delete ")) {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim());
                        toDo.deleteTask(taskNumber);
                    } catch (NumberFormatException var9) {
                        System.out.println("Invalid task number :(");
                    }
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ", 2);
                    if (parts.length != 2) {
                        throw new NyaniException("wrong format! try deadline [task] /by [date/time]!");
                    }

                    toDo.addTask(new Deadline(parts[0], parts[1]));
                } else if (input.startsWith("event ")) {
                    String[] fromPart = input.substring(6).split(" /from ", 2);
                    if (fromPart.length != 2) {
                        throw new NyaniException("wrong format! try event /from [date/time] /to [date/time]!");
                    }

                    String[] toPart = fromPart[1].split("/to ", 2);
                    if (toPart.length != 2) {
                        throw new NyaniException("wrong format! try event /from [date/time] /to [date/time]!");
                    }

                    toDo.addTask(new Event(fromPart[0], toPart[0], toPart[1]));
                } else {
                    if (input.equalsIgnoreCase("bye")) {
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

                    toDo.addTask(new ToDo(taskDescription));
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
