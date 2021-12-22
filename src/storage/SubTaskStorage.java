package storage;

import services.SubTaskInputOutput;
import services.TaskInputOutput;
import tasks.SubTask;
import tasks.Task;

import java.util.LinkedList;
import java.util.Scanner;

public class SubTaskStorage {

    private static LinkedList<SubTask> subTasks = new LinkedList<>();

    public static void setSubTaskStorage(Task task) {
        SubTask subTask = SubTaskInputOutput.saveSubTask(task);
        if (subTask != null) {
            subTasks.add(subTask);
        }
    }

    public static void setSubTaskFromUserSelect() {
        SubTask subTask = SubTaskInputOutput.saveSubTaskFromUserSelect();
        if (subTask != null) {
            subTasks.add(subTask);
        }
    }

    public static LinkedList<SubTask> getSubTasksListFromUserSelect() {
        Task task = TaskInputOutput.selectUserTaskByID();
        LinkedList<SubTask> subTasksListFromSelect = new LinkedList<>();
        if (task != null) {
            for (SubTask subTask : subTasks) {
                if (subTask.getTask().equals(task)) {
                    subTasksListFromSelect.add(subTask);
                }
            }
        }
        return subTasksListFromSelect;
    }

    public static LinkedList<SubTask> getSubTasksListByTask(Task task) {
        LinkedList<SubTask> subTasksListByTask = new LinkedList<>();
        if (task != null) {
            for (SubTask subTask : subTasks) {
                if (subTask.getTask().equals(task)) {
                    subTasksListByTask.add(subTask);
                }
            }
        }
        return subTasksListByTask;
    }

    public static LinkedList<SubTask> getSubTasksList() {
        return subTasks;
    }

    public static void removeSubTask(Task task) {
        LinkedList<SubTask> subTasksListByTask = getSubTasksListByTask(task);
        subTasks.removeAll(subTasksListByTask);
    }

    public static void removeSubTaskById() {
        SubTask selectedTask = selectUserSubTaskByID();
        subTasks.remove(selectedTask);
    }

    public static SubTask selectUserSubTaskByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите подзадачу по ID: ");
        int id = scanner.nextInt();

        SubTask subTask = null;
        for (SubTask taskSelect : subTasks) {
            if (taskSelect.getId() == id) {
                subTask = taskSelect;
            } else {
                System.out.println("Вы ввели неверный ID подзадачи");
            }
        }
        return subTask;
    }

    public static int getSubTaskIndex(SubTask subTask) {
        int index = -1;
        if (subTask != null) {
            for (SubTask t : subTasks) {
                if (t.equals(subTask)) {
                    index = subTasks.indexOf(t);
                }
            }
        }
        return index;
    }

    public static void replaceSubTask(int index, SubTask subTask) {
        subTasks.set(index, subTask);
    }

}