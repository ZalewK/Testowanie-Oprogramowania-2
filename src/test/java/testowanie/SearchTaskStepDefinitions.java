package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pw.testowanie.Priority;
import pw.testowanie.Task;
import pw.testowanie.TaskController;

public class SearchTaskStepDefinitions {

    String taskName;
    String userName;
    TaskController taskController;
    String viewName;
    ExtendedModelMap model;

    @Given("Na liście są zadania_ts_1")
    public void na_liście_są_zadania_1() {
        taskController = new TaskController();
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
            taskController.addTaskDirectly(task3);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
            taskController.addTaskDirectly(task2);
        }
    }

    @When("Wprowadza nazwę zadania")
    public void wprowadza_nazwę_zadania() {
        taskName = "1";
    }

    @When("Wciska przycisk Szukaj po nazwie")
    public void wciska_przycisk_szukaj_po_nazwie() {
        Model model = new ExtendedModelMap();
        String viewName = taskController.searchTasks("", taskName, model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }

    @Then("Wyświetlają się zadania z pasującą nazwą zadania")
    public void wyświetlają_się_zadania_z_pasującą_nazwą_zadania() {
        @SuppressWarnings("unchecked")
        List<Task> filteredTasks = (List<Task>) model.getAttribute("tasks");
        boolean allMatch = filteredTasks.stream()
                .allMatch(task -> task.getName().contains(taskName));
        assertTrue(allMatch, "All tasks should have names containing the search term");
        assertTrue(filteredTasks.size() == 1, "There should be only one task with the given user name");
    }

    @Given("Na liście są zadania_ts_2")
    public void na_liście_są_zadania_2() {
        taskController = new TaskController();
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
            taskController.addTaskDirectly(task3);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
            taskController.addTaskDirectly(task2);
        }
    }

    @When("Wprowadza nazwę użytkownika")
    public void wprowadza_nazwę_użytkownika() {
        userName = "1";
    }

    @When("Wciska przycisk Szukaj po użytkowniku")
    public void wciska_przycisk_szukaj_po_użytkowniku() {
        Model model = new ExtendedModelMap();
        String viewName = taskController.searchTasks(userName, "", model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }

    @Then("Wyświetlają się zadania z pasującą nazwą użytkownika")
    public void wyświetlają_się_zadania_z_pasującą_nazwą_użytkownika() {
        @SuppressWarnings("unchecked")
        List<Task> filteredTasks = (List<Task>) model.getAttribute("tasks");
        boolean allMatch = filteredTasks.stream()
                .allMatch(task -> task.getUser().contains(userName));
        assertTrue(allMatch, "All tasks should have user names containing the search term");
        assertTrue(filteredTasks.size() == 1, "There should be only one task with the given user name");
    }

}
