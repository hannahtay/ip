//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Nyani {

    public static void main(String[] args) throws NyaniException {
        Scanner sc = new Scanner(System.in);
        Ui ui = new Ui();
        todoList toDo = new todoList();

        ui.showIntro();
        SaveDataHandler.readSaveData(toDo);

        while (true) {
            String input = sc.nextLine();

            try {
                Command command = Parser.parse(input);
                command.execute(toDo, ui);
                if (command.isExit()) {
                    SaveDataHandler.saveData(toDo);
                    ui.showExitMsg();
                    break;
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
