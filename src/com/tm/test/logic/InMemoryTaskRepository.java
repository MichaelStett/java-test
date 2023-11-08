package com.tm.test.logic;

import com.tm.test.domain.enums.CategoryEnum;
import com.tm.test.domain.enums.PriorityEnum;
import com.tm.test.domain.enums.StatusEnum;
import com.tm.test.domain.interfaces.ITask;
import com.tm.test.domain.interfaces.ITaskRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryTaskRepository implements ITaskRepository {
    List<ITask> taskList = new ArrayList<>();
    Integer newTaskIndex = 0;

    public InMemoryTaskRepository() {
//        this.addTask("Complete menu.");
//        this.addTask("Complete options.");
//        this.addTask("Complete tutorial.");
    }

    public String getTasks() {
        return taskList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
    public String getTask(Integer id) {
        var optionalTask = taskList.stream().filter(t -> t.Id.equals(id)).findFirst();
        return optionalTask.map(ITask::toString).orElse(null);
    }
    public Integer addTask(String description, PriorityEnum priority, CategoryEnum category, LocalDate date) {
        try {
            taskList.add(new AdvancedTask(newTaskIndex, description, StatusEnum.Todo, priority, category, date));
            return newTaskIndex++;
        } catch (Exception e) {
            return -1;
        }
    }
    public boolean changeStatus(Integer id, StatusEnum status) {
        var optionalTask = findTask(id);
        if (optionalTask.isPresent() && !optionalTask.get().Status.equals(StatusEnum.Completed)) {
            optionalTask.get().setStatus(status);
            return true;
        }
        return false;
    }
    public boolean changeCategory(Integer id, CategoryEnum category) {
        // TODO: Implement
        return false;
    }
    public boolean changeDate(Integer id, LocalDate status) {
        // TODO: Implement
        return false;
    }
    public boolean removeCompleted() {
        return taskList.removeIf(t -> t.Status.equals(StatusEnum.Completed));
    }

    private Optional<ITask> findTask(Integer id){
        return taskList.stream().filter(t -> t.Id.equals(id)).findFirst();
    }
}
