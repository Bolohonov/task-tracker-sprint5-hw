package repository;

import org.junit.jupiter.api.BeforeEach;
import tasks.EpicTask;
import tasks.SingleTask;

public class FileBackedTasksManagerTest extends InMemoryTaskManagerTest implements TaskManagerTest{

    private static final Repository<SingleTask> singleTaskRepository = new Repository<>();
    private static final Repository<EpicTask> epicTaskRepository = new Repository<>();
    protected static final HistoryManager historyManager = new InMemoryHistoryManager();

    @BeforeEach
    private void clear() {
        manager.removeAllTasks();
        manager.getPrioritizedTasks().clear();
    }

    @Override
    public void putTaskStandardBehavior() {

    }

    @Override
    public void getEpicTasks() {

    }

    @Override
    public void getSubTasksByEpic() {

    }

    @Override
    public void updateTask() {

    }

    @Override
    public void removeAllTasks() {

    }

    @Override
    public void removeTaskById() {

    }

    @Override
    public void getHistory() {

    }
}
