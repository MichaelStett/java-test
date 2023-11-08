package com.tm.test.domain.enums;

import org.javatuples.Pair;

import java.util.stream.Stream;

public enum MenuOptionsEnum {
    AddTask(1, "Add Task"),
    EditTask(2, "Edit Task"),
    ViewTask(3, "View Tasks"),
    MarkAsCompleted(4,"Mark Task as Complete"),
    MarkAsInProgress(5,"Mark Task as InProgress"),
    RemoveCompleted(6, "Remove Completed Tasks"),
    Exit(7, "Exit");

    final Integer number;
    final String description;

    MenuOptionsEnum(Integer number, String description) {
        this.number = number;
        this.description = description;
    }

    public Pair<Integer, String> asPair() {
        return new Pair<>(number, description);
    }

    public static Stream<MenuOptionsEnum> stream() {
        return Stream.of(MenuOptionsEnum.values());
    }

    public static MenuOptionsEnum valueOf(Integer number) {
        for (MenuOptionsEnum e : values()) {
            if (e.number.equals(number)) {
                return e;
            }
        }
        throw new IllegalArgumentException(number.toString());
    }
}
