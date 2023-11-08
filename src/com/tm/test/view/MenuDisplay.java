package com.tm.test.view;

import com.tm.test.domain.enums.MenuOptionsEnum;

import static java.text.MessageFormat.format;

public class MenuDisplay {
    private final String Text;

    public MenuDisplay() {
        StringBuilder sb = new StringBuilder();

        sb.append("-----------------\n");
        sb.append("Task Manager Menu:");
        for (var opt :
                MenuOptionsEnum.stream()
                        .sorted()
                        .map(MenuOptionsEnum::asPair)
                        .toList()){
            String result = format("\n{0}. {1}", opt.getValue0(), opt.getValue1());

            sb.append(result);
        }

        Text = sb.toString();
    }

    public String getText() {
        return Text;
    }
}
