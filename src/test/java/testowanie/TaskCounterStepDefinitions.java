package testowanie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pw.testowanie.Priority;
import pw.testowanie.Status;
import pw.testowanie.Task;
import pw.testowanie.TaskController;

public class TaskCounterStepDefinitions {

    TaskController taskController;

    @Given("Użytkownik uruchamia aplikację_to_1")
    public void użytkownik_uruchamia_aplikację_1() {
        taskController = new TaskController();
    }

    @When("Na liście są zadania")
    public void na_liście_są_zadania() {
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() > 0)
            taskList.clear();

        Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
        taskController.addTaskDirectly(task1);
        Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
        taskController.addTaskDirectly(task3);
        Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
        taskController.addTaskDirectly(task2);

    }

    @Then("Wyświetla się liczba zadań")
    public void wyświetla_się_liczba_zadań() {
        Model model = new ExtendedModelMap();
        taskController.index(model);
        Long taskCount = (Long) model.getAttribute("totalTasks");
        assertEquals(3, taskCount, "The total number of tasks should be 3");
    }

    @Given("Użytkownik uruchamia aplikację_to_2")
    public void użytkownik_uruchamia_aplikację_2() {
        taskController = new TaskController();
    }

    @When("Na liście są ukończone zadania")
    public void na_liście_są_ukończone_zadania() {
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() > 0)
            taskList.clear();

        Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
        task1.setStatus(Status.COMPLETED);
        taskController.addTaskDirectly(task1);
        Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
        taskController.addTaskDirectly(task3);
        Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
        task2.setStatus(Status.COMPLETED);
        taskController.addTaskDirectly(task2);
    }

    @Then("Wyświetla się liczba ukończonych zadań")
    public void wyświetla_się_liczba_ukończonych_zadań() {
        Model model = new ExtendedModelMap();
        taskController.index(model);
        Long completedTaskCount = (Long) model.getAttribute("completedTasks");
        assertEquals(2, completedTaskCount, "The number of completed tasks should be 3");
    }

    @Given("Użytkownik uruchamia aplikację_to_3")
    public void użytkownik_uruchamia_aplikację_3() {
        taskController = new TaskController();
    }

    @When("Na liście są nieukończone zadania")
    public void na_liście_są_nieukończone_zadania() {
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() > 0)
            taskList.clear();

        Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
        taskController.addTaskDirectly(task1);
        Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
        taskController.addTaskDirectly(task3);
        Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
        taskController.addTaskDirectly(task2);
    }

    @Then("Wyświetla się liczba nieukończonych zadań")
    public void wyświetla_się_liczba_nieukończonych_zadań() {
        Model model = new ExtendedModelMap();
        taskController.index(model);
        Long inProgressTaskCount = (Long) model.getAttribute("inProgressTasks");
        assertEquals(3, inProgressTaskCount, "The number of in-progress tasks should be 3");
    }

}
