package services;

import storage.SubTaskStorage;
import storage.TaskStatus;
import storage.TaskStorage;
import tasks.SubTask;
import tasks.Task;

import java.util.Arrays;
import java.util.Scanner;

public class TaskUpdater {

    public static void updateTask() {
        Task task = TaskInputOutput.selectUserTaskByID();
        int index = TaskStorage.getTaskIndex(task);
        int command = -1;
        while (command != 0) {
            Print.printMenuToUpdateTask();
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextInt();
            switch (command) {
                case 0:
                    break;
                case 1:
                    System.out.println("Введите новое название задачи");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    if (name != null) {
                        task.setName(name);
                    }
                    TaskStorage.replaceTask(index, task);
                    break;
                case 2:
                    System.out.println("Введите новое описание задачи");
                    scanner = new Scanner(System.in);
                    String description = scanner.nextLine();
                    if (description != null) {
                        task.setDescription(description);
                    }
                    TaskStorage.replaceTask(index, task);
                    break;
                case 3:
                    System.out.println(task.getStatus());
                    System.out.println("Выберите статус");
                    Print.printStatusList();
                    scanner = new Scanner(System.in);
                    String status = scanner.nextLine();
                    if (Arrays.stream(TaskStatus.values())
                            .anyMatch((t) -> t.name().equals(status))) {
                        task.setStatus(TaskStatus.valueOf(status));
                    } else {
                        System.out.println("Указан неверный статус!");
                    }
                    break;
                default:
                    System.out.println("Вы ввели неверное значение!");
                    break;
            }
        }
    }

    public static void updateSubTask() {
        SubTask subTask = SubTaskStorage.selectUserSubTaskByID();
        int index = SubTaskStorage.getSubTaskIndex(subTask);
        int command = -1;
        while (command != 0) {
            Print.printMenuToUpdateTask();
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextInt();
            switch (command) {
                case 0:
                    break;
                case 1:
                    System.out.println("Введите новое название задачи");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    if (name != null) {
                        subTask.setName(name);
                    }
                    SubTaskStorage.replaceSubTask(index, subTask);
                    break;
                case 2:
                    System.out.println("Введите новое описание задачи");
                    scanner = new Scanner(System.in);
                    String description = scanner.nextLine();
                    if (description != null) {
                        subTask.setDescription(description);
                    }
                    TaskStorage.replaceTask(index, subTask);
                    break;
                case 3:
                    System.out.println(subTask.getStatus());
                    System.out.println("Выберите статус");
                    Print.printStatusList();
                    scanner = new Scanner(System.in);
                    String status = scanner.nextLine();
                    if (Arrays.stream(TaskStatus.values())
                            .anyMatch((t) -> t.name().equals(status))) {
                        subTask.setStatus(TaskStatus.valueOf(status));
                    } else {
                        System.out.println("Указан неверный статус!");
                    }
                    break;
                default:
                    System.out.println("Вы ввели неверное значение!");
                    break;
            }
        }
    }
}