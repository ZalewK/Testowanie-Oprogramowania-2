package testowanie;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
    @Then("Wyświetlone są tylko nieukończone zadania")
    public void wyświetlone_są_tylko_nieukończone_zadania() {

        List<Task> allTasks = taskController.getTasks();
        Task addedTask1 = allTasks.remove(0);
        Task addedTask2 = allTasks.remove(0);

        assertEquals(Status.IN_PROGRESS, addedTask1.getStatus());
        assertEquals(Status.IN_PROGRESS, addedTask2.getStatus());
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
    }
    @Then("Wyświetlone są tylko ukończone zadania")
    public void wyświetlone_są_tylko_ukończone_zadania() {

        List<Task> allTasks = taskController.getTasks();
        Task addedTask1 = allTasks.remove(allTasks.size()-1);
        Task addedTask2 = allTasks.remove(allTasks.size()-1);

        assertEquals(Status.COMPLETED, addedTask1.getStatus());
        assertEquals(Status.COMPLETED, addedTask2.getStatus());
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
    }
    @Then("Wszystkie zadania są wyświetlone")
    public void wszystkie_zadania_są_wyświetlone() {

        List<Task> allTasks = taskController.getTasks();

        Task addedTask1 = allTasks.remove(0);
        Task addedTask2 = allTasks.remove(0);
        Task addedTask3 = allTasks.remove(0);
        Task addedTask4 = allTasks.remove(0);

        assertEquals("Task Name 1", addedTask1.getName());
        assertEquals("Details 1", addedTask1.getDetails());
        assertEquals("User 1", addedTask1.getUser());
        assertEquals(Priority.HIGH, addedTask1.getPriority());
        assertEquals(Status.IN_PROGRESS, addedTask1.getStatus());

        assertEquals("Task Name 2", addedTask2.getName());
        assertEquals("Details 2", addedTask2.getDetails());
        assertEquals("User 2", addedTask2.getUser());
        assertEquals(Priority.LOW, addedTask2.getPriority());
        assertEquals(Status.COMPLETED, addedTask2.getStatus());

        assertEquals("Task Name 3", addedTask3.getName());
        assertEquals("Details 3", addedTask3.getDetails());
        assertEquals("User 3", addedTask3.getUser());
        assertEquals(Priority.MEDIUM, addedTask3.getPriority());
        assertEquals(Status.IN_PROGRESS, addedTask3.getStatus());

        assertEquals("Task Name 4", addedTask4.getName());
        assertEquals("Details 4", addedTask4.getDetails());
        assertEquals("User 4", addedTask4.getUser());
        assertEquals(Priority.MEDIUM, addedTask4.getPriority());
        assertEquals(Status.COMPLETED, addedTask4.getStatus());


    }
    
}
