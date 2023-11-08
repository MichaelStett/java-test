package com.tm.test.domain.interfaces;

import com.tm.test.domain.enums.StatusEnum;

public interface ITask {
    Integer Id = 0;
    String Description = "";
    StatusEnum Status = StatusEnum.Todo;
    StatusEnum getStatus();
    void setStatus(StatusEnum status);
}
