package com.tm.test.domain.interfaces;

import com.tm.test.domain.enums.CategoryEnum;
import com.tm.test.domain.enums.PriorityEnum;
import com.tm.test.domain.enums.StatusEnum;

import java.time.LocalDate;

public interface ITaskRepository {
    String getTasks();
    String getTask(Integer id);

    Integer addTask(String description, PriorityEnum priority, CategoryEnum category, LocalDate date);

    boolean changeStatus(Integer id, StatusEnum status);
    boolean changeCategory(Integer id, CategoryEnum category);
    boolean changeDate(Integer id, LocalDate status);

    boolean removeCompleted();
}
