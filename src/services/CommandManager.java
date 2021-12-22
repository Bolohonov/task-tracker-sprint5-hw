package services;

import java.util.Scanner;

import storage.SubTaskStorage;
import storage.TaskStorage;

public class CommandManager {

    Scanner scanner = new Scanner(System.in);

    public void getCommandPanel() {
        int command = -1;

        while (command != 0) {
            Print.printMenu();
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    TaskStorage.setTaskStorage();
                    break;
                case 2:
                    SubTaskStorage.setSubTaskFromUserSelect();
                    break;
                case 3:
                    Print.printSubTaskList(SubTaskStorage.getSubTasksList());
                    break;
                case 4:
                    Print.printSubTaskList(SubTaskStorage.getSubTasksListFromUserSelect());
                    break;
                case 5:
                    break;
                case 6:
                    TaskUpdater.updateTask();
                    break;
                case 7: break;
                case 8:
                    TaskStorage.removeTask();
                    Print.printDeleted();
                    break;
                case 9:
                    SubTaskStorage.removeSubTaskById();
                    Print.printDeleted();
                    break;
                case 0:
                    Print.printExit();
                    break;
                default:
                    Print.printNoCommand();
                    break;
            }
        }
    }
}
