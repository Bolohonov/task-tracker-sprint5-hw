package tasks;

import repository.TaskManager;
import repository.TaskStatus;

import java.util.Objects;

public class EpicTask extends SingleTask{

    private String name;
    private String description;
    private int id;
    private TaskStatus status;

    public EpicTask(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = calcAndCheckId();
        this.status = TaskStatus.NEW;
    }

    @Override
    public String toString() {
        return "Эпик{" +
                "Имя='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", ID=" + id +
                ", Статус=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpicTask task = (EpicTask) o;
        return id == task.id &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, description, id, status);
        result = 37 * result + id;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public int calcAndCheckId() {
        int id = (int) (Math.random() * 17 + Math.random() * 137);
        TaskManager manager = new TaskManager();
        if (manager.returnObject(id) == null) {
        } else {
            calcAndCheckId();
        }
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
