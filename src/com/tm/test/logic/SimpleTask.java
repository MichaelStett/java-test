package com.tm.test.logic;

import com.tm.test.domain.enums.StatusEnum;
import com.tm.test.domain.interfaces.ITask;

import static java.text.MessageFormat.format;

public abstract class SimpleTask implements ITask {
    private final Integer Id;
    private final String Description;
    private StatusEnum Status;

    public SimpleTask(Integer id, String description, StatusEnum status) {
        Id = id;
        Description = description;
        Status = status;
    }

    @Override
    public String toString() {
        return format("ID: {0}, Description: {1}, Status: {2}", Id, Description, Status);
    }

    public StatusEnum getStatus() {
        return Status;
    }

    public void setStatus(StatusEnum status) {
        Status = status;
    }
}
