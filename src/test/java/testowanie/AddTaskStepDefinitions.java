package testowanie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.cucumber.java.en.*;

import java.util.List;
import pw.testowanie.TaskController;
import pw.testowanie.Task;
import pw.testowanie.Priority;

public class AddTaskStepDefinitions {

    // 1

    private TaskController taskController;
    private String taskName;
    private String taskDetails;
    private String assignedUser;
    private Priority assignedPriority;

    @Given("Użytkownik uruchamia aplikację_1")
    public void użytkownik_uruchamia_aplikację_1() {
        taskController = new TaskController();
    }
    @When("Wprowadza poprawną nazwę zadania")
    public void wprowadza_poprawną_nazwę_zadania() {
        taskName = "Nowe Zadanie 1";
        taskDetails = "";
        assignedUser = "";
        assignedPriority = Priority.LOW; 
    }
    @And("Wciska przycisk Add_1")
    public void wciska_przycisk_add_1() {
        taskController.addTaskDirectly(new Task(taskName, taskDetails, assignedUser, assignedPriority));
    }
    @Then("Nowe zadanie z samą nazwą zostaje dodane na listę zadań")
    public void nowe_zadanie_z_samą_nazwą_zostaje_dodane_na_listę_zadań() {
            List<Task> tasks = taskController.getTasks();
            Task addedTask = tasks.get(0);
            assertEquals(1, tasks.size());
            assertEquals("Nowe Zadanie 1", addedTask.getName());
            assertEquals("", addedTask.getDetails());
            assertEquals("", addedTask.getUser());
            assertEquals(Priority.LOW, addedTask.getPriority());
    }

    // 2

    @Given("Użytkownik uruchamia aplikację_2")
    public void użytkownik_uruchamia_aplikację_2() {
        taskController = new TaskController();
    }
    @When("Wprowadza poprawną nazwę zadania oraz jego szczegóły")
    public void wprowadza_poprawną_nazwę_zadania_oraz_jego_szczegóły() {
        taskName = "Nowe Zadanie 2";
        taskDetails = "Szczegóły zadania 2";
        assignedUser = "";
        assignedPriority = Priority.LOW; 
    }
    @And("Wciska przycisk Add_2")
    public void wciska_przycisk_add_2() {
        taskController.addTaskDirectly(new Task(taskName, taskDetails, assignedUser, assignedPriority));
    }
    @Then("Nowe zadanie z nazwą oraz szczegółami zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_oraz_szczegółami_zostaje_dodane_na_listę_zadań() {
            List<Task> tasks = taskController.getTasks();
            Task addedTask = tasks.get(0);
            assertEquals(1, tasks.size());
            assertEquals("Nowe Zadanie 2", addedTask.getName());
            assertEquals("Szczegóły zadania 2", addedTask.getDetails());
            assertEquals("", addedTask.getUser());
            assertEquals(Priority.LOW, addedTask.getPriority());
    }

    // 3

    @Given("Użytkownik uruchamia aplikację_3")
    public void użytkownik_uruchamia_aplikację_3() {
        taskController = new TaskController();
    }
    @When("Wprowadza poprawną nazwę zadania oraz użytkownika")
    public void wprowadza_poprawną_nazwę_zadania_oraz_użytkownika() {
        taskName = "Nowe Zadanie 3";
        taskDetails = "";
        assignedUser = "Nowy User 3";
        assignedPriority = Priority.LOW; 
    }
    @And("Wciska przycisk Add_3")
    public void wciska_przycisk_add_3() {
        taskController.addTaskDirectly(new Task(taskName, taskDetails, assignedUser, assignedPriority));
    }
    @Then("Nowe zadanie z nazwą oraz przypisanym użytkownikiem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_oraz_przypisanym_użytkownikiem_zostaje_dodane_na_listę_zadań() {
        List<Task> tasks = taskController.getTasks();
            Task addedTask = tasks.get(0);
            assertEquals(1, tasks.size());
            assertEquals("Nowe Zadanie 3", addedTask.getName());
            assertEquals("", addedTask.getDetails());
            assertEquals("Nowy User 3", addedTask.getUser());
            assertEquals(Priority.LOW, addedTask.getPriority());
    }

    // 4

    @Given("Użytkownik uruchamia aplikację_4")
    public void użytkownik_uruchamia_aplikację_4() {
        taskController = new TaskController();
    }
    @When("Wprowadza poprawną nazwę zadania, użytkownika oraz priorytet")
    public void wprowadza_poprawną_nazwę_zadania_użytkownika_oraz_priorytet() {
        taskName = "Nowe Zadanie 4";
        taskDetails = "";
        assignedUser = "Nowy User 4";
        assignedPriority = Priority.MEDIUM; 
    }
    @And("Wciska przycisk Add_4")
    public void wciska_przycisk_add_4() {
        taskController.addTaskDirectly(new Task(taskName, taskDetails, assignedUser, assignedPriority));
    }
    @Then("Nowe zadanie z nazwą, przypisanym użytkownikiem oraz priorytetem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_przypisanym_użytkownikiem_oraz_priorytetem_zostaje_dodane_na_listę_zadań() {
        List<Task> tasks = taskController.getTasks();
            Task addedTask = tasks.get(0);
            assertEquals(1, tasks.size());
            assertEquals("Nowe Zadanie 4", addedTask.getName());
            assertEquals("", addedTask.getDetails());
            assertEquals("Nowy User 4", addedTask.getUser());
            assertEquals(Priority.MEDIUM, addedTask.getPriority());
    }

    // 5

    @Given("Użytkownik uruchamia aplikację_5")
    public void użytkownik_uruchamia_aplikację_5() {
        taskController = new TaskController();
    }
    @When("Wprowadza poprawną nazwę zadania, jego szczegóły oraz użytkownika")
    public void wprowadza_poprawną_nazwę_zadania_jego_szczegóły_oraz_użytkownika() {
        taskName = "Nowe Zadanie 5";
        taskDetails = "Szczegóły zadania 5";
        assignedUser = "Nowy User 5";
        assignedPriority = Priority.LOW; 
    }
    @And("Wciska przycisk Add_5")
    public void wciska_przycisk_add_5() {
        taskController.addTaskDirectly(new Task(taskName, taskDetails, assignedUser, assignedPriority));
    }
    @Then("Nowe zadanie z nazwą, szczegółami oraz przypisanym użytkownikiem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_szczegółami_oraz_przypisanym_użytkownikiem_zostaje_dodane_na_listę_zadań() {
        List<Task> tasks = taskController.getTasks();
            Task addedTask = tasks.get(0);
            assertEquals(1, tasks.size());
            assertEquals("Nowe Zadanie 5", addedTask.getName());
            assertEquals("Szczegóły zadania 5", addedTask.getDetails());
            assertEquals("Nowy User 5", addedTask.getUser());
            assertEquals(Priority.LOW, addedTask.getPriority());
    }

    // 6

    @Given("Użytkownik uruchamia aplikację_6")
    public void użytkownik_uruchamia_aplikację_6() {
        taskController = new TaskController();
    }
    @When("Wprowadza poprawną nazwę zadania, jego szczegóły, użytkownika oraz priorytet")
    public void wprowadza_poprawną_nazwę_zadania_jego_szczegóły_użytkownika_oraz_priorytet() {
        taskName = "Nowe Zadanie 6";
        taskDetails = "Szczegóły zadania 6";
        assignedUser = "Nowy User 6";
        assignedPriority = Priority.HIGH; 
    }
    @And("Wciska przycisk Add_6")
    public void wciska_przycisk_add_6() {
        taskController.addTaskDirectly(new Task(taskName, taskDetails, assignedUser, assignedPriority));
    }
    @Then("Nowe zadanie z nazwą, szczegółami, przypisanym użytkownikiem oraz priorytetem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_szczegółami_przypisanym_użytkownikiem_oraz_priorytetem_zostaje_dodane_na_listę_zadań() {
        List<Task> tasks = taskController.getTasks();
            Task addedTask = tasks.get(0);
            assertEquals(1, tasks.size());
            assertEquals("Nowe Zadanie 6", addedTask.getName());
            assertEquals("Szczegóły zadania 6", addedTask.getDetails());
            assertEquals("Nowy User 6", addedTask.getUser());
            assertEquals(Priority.HIGH, addedTask.getPriority());
    }

}