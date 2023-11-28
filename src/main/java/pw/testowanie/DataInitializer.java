package pw.testowanie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TaskController taskController;

    public DataInitializer(TaskController taskController) {
        this.taskController = taskController;
    }

    @Override
    public void run(String... args) {
        List<Task> initialTasks = Arrays.asList(
                new Task("Task 1", "Details for task 1", "User1", Priority.LOW),
                new Task("Task 2", "", "User2", Priority.LOW),
                new Task("Task 3", "Details for task 3", "", Priority.MEDIUM),
                new Task("Task 4", "", "", Priority.LOW),
                new Task("Task 5", "Details for task 5", "User5", Priority.HIGH)
        );

        initialTasks.forEach(taskController::addTaskDirectly);
    }

}
