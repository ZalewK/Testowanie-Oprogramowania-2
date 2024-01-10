package testowanie.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import pw.testowanie.Priority;
import pw.testowanie.TaskController;
import pw.testowanie.Task;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class TaskControllerBenchmark {

    private TaskController taskController;

    @Setup
    public void setup() {
        taskController = new TaskController();
        // Symulacja danych inicjalizacyjnych
        List<Task> initialTasks = new ArrayList<>();
        initialTasks.add(new Task("Task 1", "Details for task 1", "User1", Priority.LOW));
        initialTasks.add(new Task("Task 2", "", "User2", Priority.LOW));
        initialTasks.add(new Task("Task 3", "Details for task 3", "", Priority.MEDIUM));
        initialTasks.add(new Task("Task 4", "", "", Priority.LOW));
        initialTasks.add(new Task("Task 5", "Details for task 5", "User5", Priority.HIGH));

        initialTasks.forEach(taskController::addTaskDirectly);
    }

    @Benchmark
    public void testAddTask() {
        taskController.addTask("New Test Task", "Details", "User", Priority.MEDIUM);
    }
}
