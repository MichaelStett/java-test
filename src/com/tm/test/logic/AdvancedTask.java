package com.tm.test.logic;

import com.tm.test.domain.enums.CategoryEnum;
import com.tm.test.domain.enums.PriorityEnum;
import com.tm.test.domain.enums.StatusEnum;

import java.time.LocalDate;

import static java.text.MessageFormat.format;

class AdvancedTask extends SimpleTask {
    public final PriorityEnum Priority;
    public final CategoryEnum Category;
    public final LocalDate Date;

    public AdvancedTask(
            Integer id, String description, StatusEnum status,
            PriorityEnum priority, CategoryEnum category, LocalDate date
    ) {
        super(id, description, status);
        Priority = priority;
        Category = category;
        Date = date;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " +
                format("Priority: {0}, Category: {1}, Date: {2}", Priority, Category, Date);
    }
}
