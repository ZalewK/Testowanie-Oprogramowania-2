package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pw.testowanie.Priority;
import pw.testowanie.Status;
import pw.testowanie.Task;
import pw.testowanie.TaskController;

public class TaskCompletionStepDefinitions {

    TaskController tasks = new TaskController();
    long taskId;

    @Given("Na liście jest wykonane zadanie")
    public void na_liście_jest_wykonane_zadanie() {
        List<Task> taskList = tasks.getTasks();

        boolean hasCompletedTask = false;
        for (Task task : taskList) {
            if (task.getStatus().equals(Status.COMPLETED)) {
                hasCompletedTask = true;
                taskId = task.getId();
                break;
            }
        }
        if (!hasCompletedTask) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskId = task1.getId();
            tasks.addTaskDirectly(task1);
            tasks.toggleTaskStatus(task1.getId());
        }
    }

    @When("Wciskamy przycisk Change status_tc_2")
    public void wciskamy_przycisk_change_status_kiedy_wykonane() {
        tasks.toggleTaskStatus(taskId);
    }

    @Then("Zadanie pokazuje się jako niewykonane")
    public void zadanie_pokazuje_się_jako_niewykonane() {
        assertTrue(tasks.getTaskById(taskId).getStatus().equals(Status.IN_PROGRESS));
    }

    @Given("Na liście jest niewykonane zadanie")
    public void na_liście_jest_niewykonane_zadanie() {
        List<Task> taskList = tasks.getTasks();

        boolean hasCompletedTask = false;
        for (Task task : taskList) {
            if (task.getStatus().equals(Status.IN_PROGRESS)) {
                hasCompletedTask = true;
                taskId = task.getId();
                break;
            }
        }
        if (!hasCompletedTask) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskId = task1.getId();
            tasks.addTaskDirectly(task1);
        }
    }

    @When("Wciskamy przycisk Change status_tc_1")
    public void wciskamy_przycisk_change_status_kiedy_niewykonane() {
        tasks.toggleTaskStatus(taskId);
    }

    @Then("Zadanie pokazuje się jako wykonane")
    public void zadanie_pokazuje_się_jako_wykonane() {
        assertTrue(tasks.getTaskById(taskId).getStatus().equals(Status.COMPLETED));
    }

}
