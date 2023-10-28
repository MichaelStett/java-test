import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskManager {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final MenuDisplay menu = new MenuDisplay();
    final TaskRepository repository = new TaskRepository();

    public void Run() {
        try {
            System.out.println(menu.Text);
            System.out.print("Enter your choice: ");
            MenuOptionsEnum input = getMenuOptionInput();

            while (!input.equals(MenuOptionsEnum.Exit)) {
                switch (input) {
                    case AddTask -> {
                        System.out.print("Enter task description:");
                        var temp = br.readLine();
                        var id = repository.addTask(temp);
                        if (id != -1) {
                            System.out.println("Added task: " + repository.getTask(id));
                        } else {
                            System.out.println("Task has not been added.");
                        }
                    }
                    case ViewTask -> {
                        String tasks = repository.getTasks();
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks available.");
                        } else {
                            System.out.println("Tasks: \n" + tasks);
                        }
                    }
                    case MarkAsCompleted -> {
                        System.out.print("Enter task ID to mark as complete:");
                        var id = Integer.parseInt(br.readLine());
                        if (repository.completeTask(id)) {
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

                System.out.println(menu.Text);
                System.out.print("Enter your choice: ");
                input = getMenuOptionInput();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        System.out.println("Exiting Task Manager. Goodbye!");
    }

    private MenuOptionsEnum getMenuOptionInput() throws IOException {
        return MenuOptionsEnum.valueOf(Integer.parseInt(br.readLine()));
    }
}
