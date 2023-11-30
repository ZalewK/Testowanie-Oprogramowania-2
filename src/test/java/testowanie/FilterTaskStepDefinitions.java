package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;

import java.util.List;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import pw.testowanie.TaskController;
import pw.testowanie.Task;
import pw.testowanie.Priority;
import pw.testowanie.Status;

public class FilterTaskStepDefinitions {
    
    // 1

    private TaskController taskController;
    String viewName;
    String viewName1;
    String viewName2;
    ExtendedModelMap model;

    @Given("Na liście są nieukończone zadania_f")
    public void na_liście_są_nieukończone_zadania() {

        taskController = new TaskController();
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.LOW);
            task2.setStatus(Status.COMPLETED);
            taskController.addTaskDirectly(task2);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.MEDIUM);
            taskController.addTaskDirectly(task3);
            Task task4 = new Task("Task Name 4", "Details 4", "User 4", Priority.MEDIUM);
            task4.setStatus(Status.COMPLETED);
            taskController.addTaskDirectly(task4);
        }
    }
    @When("Zaznacza opcję Filtruj po nieukończonych")
    public void zaznacza_opcję_filtruj_po_nieukończonych() {

        taskController.sort("status");

        Model model = new ExtendedModelMap();
        String viewName = taskController.filterTasks("inProgress", model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }
    @Then("Wyświetlone są tylko nieukończone zadania")
    public void wyświetlone_są_tylko_nieukończone_zadania() {

        @SuppressWarnings("unchecked")
        List<Task> filteredTasks = (List<Task>) model.getAttribute("tasks");
        boolean allMatch = filteredTasks.stream()
        .allMatch(task -> task.getStatus().equals(Status.IN_PROGRESS));

        assertTrue(allMatch);
        assertTrue(filteredTasks.size() == 2);
    }

    // 2

    @Given("Na liście są ukończone zadania_f")
    public void na_liście_są_ukończone_zadania() {

        taskController = new TaskController();
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.LOW);
            task2.setStatus(Status.COMPLETED);
            taskController.addTaskDirectly(task2);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.MEDIUM);
            taskController.addTaskDirectly(task3);
            Task task4 = new Task("Task Name 4", "Details 4", "User 4", Priority.MEDIUM);
            task4.setStatus(Status.COMPLETED);
            taskController.addTaskDirectly(task4);
        }
    }
    @When("Zaznacza opcję Filtruj po ukończonych")
    public void zaznacza_opcję_filtruj_po_ukończonych() {

        taskController.sort("status");

        Model model = new ExtendedModelMap();
        String viewName = taskController.filterTasks("completed", model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }
    @Then("Wyświetlone są tylko ukończone zadania")
    public void wyświetlone_są_tylko_ukończone_zadania() {

        @SuppressWarnings("unchecked")
        List<Task> filteredTasks = (List<Task>) model.getAttribute("tasks");
        boolean allMatch = filteredTasks.stream()
        .allMatch(task -> task.getStatus().equals(Status.COMPLETED));

        assertTrue(allMatch);
        assertTrue(filteredTasks.size() == 2);
    }

    // 3

    @Given("Użytkownik uruchamia aplikację_f")
    public void użytkownik_uruchamia_aplikację() {
        
        taskController = new TaskController();
    }
    @When("Na liście są zadania_f")
    public void na_liście_są_zadania() {

        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.LOW);
            task2.setStatus(Status.COMPLETED);
            taskController.addTaskDirectly(task2);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.MEDIUM);
            taskController.addTaskDirectly(task3);
            Task task4 = new Task("Task Name 4", "Details 4", "User 4", Priority.MEDIUM);
            task4.setStatus(Status.COMPLETED);
            taskController.addTaskDirectly(task4);
        }

        Model model = new ExtendedModelMap();
        String viewName = taskController.filterTasks("", model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }
    @Then("Wszystkie zadania są wyświetlone")
    public void wszystkie_zadania_są_wyświetlone() {

        @SuppressWarnings("unchecked")
        List<Task> filteredTasks = (List<Task>) model.getAttribute("tasks");

        assertTrue(filteredTasks.size() == 4);
    }
    
}
