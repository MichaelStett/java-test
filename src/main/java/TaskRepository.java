import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {
    List<Task> taskList = new ArrayList<>();
    Integer newTaskIndex = 0;

    TaskRepository() {
        // mock data for tests
        this.addTask("Complete menu.");
        this.addTask("Complete options.");
        this.addTask("Complete tutorial.");
    }

    String getTasks() {
        return taskList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    String getTask(Integer id) {
        var optionalTask = taskList.stream().filter(t -> t.Id.equals(id)).findFirst();
        return optionalTask.map(Task::toString).orElse(null);
    }

    Integer addTask(String description) {
        try {
            taskList.add(new Task(newTaskIndex, description, StatusEnum.Todo));
            return newTaskIndex++;
        } catch (Exception e) {
            return -1;
        }
    }

    boolean completeTask(Integer id) {
        var optionalTask = taskList.stream().filter(t -> t.Id.equals(id)).findFirst();
        if (optionalTask.isPresent()) {
            optionalTask.get().Status = StatusEnum.Completed;
            return true;
        }
        return false;
    }

    boolean removeCompleted() {
        return taskList.removeIf(t -> t.Status.equals(StatusEnum.Completed));
    }
}
