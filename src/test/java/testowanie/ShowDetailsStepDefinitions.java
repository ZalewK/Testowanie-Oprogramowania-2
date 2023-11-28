package testowanie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pw.testowanie.Priority;
import pw.testowanie.Task;
import pw.testowanie.TaskController;

public class ShowDetailsStepDefinitions {

    TaskController taskController;
    long taskId;
    String viewName;
    ExtendedModelMap model;

    @Given("Użytkownik posiada dodane zadanie")
    public void użytkownik_posiada_dodane_zadanie() {
        taskController = new TaskController();
        Task task = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
        taskId = task.getId();
        taskController.addTaskDirectly(task);
    }

    @When("Wciska przycisk Details")
    public void wciska_przycisk_details() {
        Model model = new ExtendedModelMap();
        String viewName = taskController.taskDetails(taskId, model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }

    @Then("Wyświetla się okno z detalami zadania")
    public void wyświetla_się_okno_z_detalami_zadania() {
        Task task = (Task) model.getAttribute("task");
        assertNotNull(task, "Task should not be null");
        assertEquals(taskId, task.getId(), "The task ID should match the requested task's ID");
        assertEquals("taskDetails", viewName, "The view should be 'taskDetails'");
        assertEquals(task.getDetails(), "Details 1");
    }

}
