import org.javatuples.Pair;

import java.util.stream.Stream;

public enum MenuOptionsEnum {
    AddTask(1, "Add Task"),
    ViewTask(2, "View Tasks"),
    MarkAsCompleted(3,"Mark Task as Complete"),
    RemoveCompleted(4, "Remove Completed Tasks"),
    Exit(5, "Exit");

    final Integer number;
    final String description;

    MenuOptionsEnum(Integer number, String description) {
        this.number = number;
        this.description = description;
    }

    Pair<Integer, String> asPair() {
        return new Pair<>(number, description);
    }

    static Stream<MenuOptionsEnum> stream() {
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
