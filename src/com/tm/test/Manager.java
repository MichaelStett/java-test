package com.tm.test;

import com.tm.test.domain.enums.MenuOptionsEnum;
import com.tm.test.domain.enums.StatusEnum;
import com.tm.test.domain.interfaces.ITaskRepository;
import com.tm.test.logic.InMemoryTaskRepository;
import com.tm.test.view.MenuDisplay;

import java.io.IOException;
import java.util.Scanner;

import static java.text.MessageFormat.format;

public class Manager {
    final static Scanner reader = new Scanner(System.in);
    final static MenuDisplay menu = new MenuDisplay();
    final static ITaskRepository repository = new InMemoryTaskRepository();

    public static void Run() {
        try {
            System.out.println(menu.getText());
            System.out.print("Enter your choice: ");
            MenuOptionsEnum input = getMenuOptionInput();

            while (!input.equals(MenuOptionsEnum.Exit)) {
                switch (input) {
                    case AddTask -> {
                        System.out.print("Enter task description:");
                        var desc = reader.nextLine();
                        // TODO: Add other inputs

//                        var id = repository.addTask(temp);
//                        if (id != -1) {
//                            System.out.println(format("Added task: {0}", repository.getTask(id)));
//                        } else {
//                            System.out.println("Task has not been added.");
//                        }
                    }
                    case ViewTask -> {
                        String tasks = repository.getTasks();
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks available.");
                        } else {
                            System.out.println(format("Tasks: \n{0}", tasks));
                        }
                    }
                    case MarkAsCompleted -> {
                        System.out.print("Enter task ID to mark as complete:");
                        var id = Integer.parseInt(reader.nextLine());
                        if (repository.changeStatus(id, StatusEnum.Completed)) {
                            System.out.println("Task marked as complete successfully!");
                        } else {
                            System.out.println("Unable to mark task as completed!");
                        }
                    }
                    case RemoveCompleted -> {
                        if (repository.removeCompleted()) {
                            System.out.println("Completed tasks removed.");
                        } else {
                            System.out.println("No tasks to be removed.");
                        }
                    }
                }

                System.out.println(menu.getText());
                System.out.print("Enter your choice: ");
                input = getMenuOptionInput();
            }
        } catch (Exception e) {
            System.out.println(format("Exception occurred: {0}", e));
        }

        System.out.println("Exiting Task Manager. Goodbye!");
    }

    private static MenuOptionsEnum getMenuOptionInput() throws IOException {
        return MenuOptionsEnum.valueOf(Integer.parseInt(reader.nextLine()));
    }
}
