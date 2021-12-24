package tasks;

import repository.TaskStatus;

import java.util.Objects;

public class SubTask extends Task {
    EpicTask epicTask;
    String name;
    String description;
    long id;
    TaskStatus status;

    public SubTask(EpicTask epicTask, String name, String description, long id, TaskStatus status) {
        this.epicTask = epicTask;
        this.name = name;
        this.description = description;
        this.id = id;
        this.status = status;
    }

    public EpicTask getTask() {
        return epicTask;
    }

    @Override
    public String toString() {
        return "Подзадача{" +
                "Имя эпика=" + epicTask.getName() +
                ", Имя подзадачи='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", ID=" + id +
                ", Статус=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubTask subtask = (SubTask) o;
        return id == subtask.id &&
                Objects.equals(name, subtask.name) &&
                Objects.equals(description, subtask.description) &&
                Objects.equals(status, subtask.status) &&
                (epicTask.equals(subtask.epicTask));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, description, id, status);
        result = 31 * result + epicTask.hashCode();
        return result;
    }
}
