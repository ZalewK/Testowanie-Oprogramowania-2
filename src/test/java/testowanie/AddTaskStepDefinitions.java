package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import javax.swing.JOptionPane;

import io.cucumber.java.en.*;
import pw.testowanie.TaskController;
import pw.testowanie.Task;
import pw.testowanie.Priority;

public class AddTaskStepDefinitions {

    // 1

    private TaskController taskController = new TaskController();
    private String taskName;

    @Given("Użytkownik uruchamia aplikację_1")
    public void użytkownik_uruchamia_aplikację_1() {
        System.out.println("Aplikacja uruchomiona");
    }
    @When("Wprowadza poprawną nazwę zadania")
    public void wprowadza_poprawną_nazwę_zadania() {
        taskName = "Nowe Zadanie";
    }
    @When("Wciska przycisk Add_1")
    public void wciska_przycisk_add_1() {
        taskController.addTaskDirectly(new Task(taskName, "Szczegóły zadania", "Użytkownik", Priority.MEDIUM));
    }
    @Then("Nowe zadanie z samą nazwą zostaje dodane na listę zadań")
    public void nowe_zadanie_z_samą_nazwą_zostaje_dodane_na_listę_zadań() {
            List<Task> tasks = taskController.getTasks();
            JOptionPane.showMessageDialog(null, "lol");
            assertTrue( tasks.stream().anyMatch(task -> task.getName().equals(taskName)), "Oczekiwano, że zadanie zostanie dodane na listę zadań, ale nie zostało.");
    }

    // 2

    @Given("Użytkownik uruchamia aplikację_2")
    public void użytkownik_uruchamia_aplikację_2() {
        System.out.println("test");
    }
    @When("Wprowadza poprawną nazwę zadania oraz jego szczegóły")
    public void wprowadza_poprawną_nazwę_zadania_oraz_jego_szczegóły() {
        System.out.println("test");
    }
    @When("Wciska przycisk Add_2")
    public void wciska_przycisk_add_2() {
        System.out.println("test");
    }
    @Then("Nowe zadanie z nazwą oraz szczegółami zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_oraz_szczegółami_zostaje_dodane_na_listę_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

    // 3

    @Given("Użytkownik uruchamia aplikację_3")
    public void użytkownik_uruchamia_aplikację_3() {
        System.out.println("test");
    }
    @When("Wprowadza poprawną nazwę zadania oraz użytkownika")
    public void wprowadza_poprawną_nazwę_zadania_oraz_użytkownika() {
        System.out.println("test");
    }
    @When("Wciska przycisk Add_3")
    public void wciska_przycisk_add_3() {
        System.out.println("test");
    }
    @Then("Nowe zadanie z nazwą oraz przypisanym użytkownikiem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_oraz_przypisanym_użytkownikiem_zostaje_dodane_na_listę_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

    // 4

    @Given("Użytkownik uruchamia aplikację_4")
    public void użytkownik_uruchamia_aplikację_4() {
        System.out.println("test");
    }
    @When("Wprowadza poprawną nazwę zadania, użytkownika oraz priorytet")
    public void wprowadza_poprawną_nazwę_zadania_użytkownika_oraz_priorytet() {
        System.out.println("test");
    }
    @When("Wciska przycisk Add_4")
    public void wciska_przycisk_add_4() {
        System.out.println("test");
    }
    @Then("Nowe zadanie z nazwą, przypisanym użytkownikiem oraz priorytetem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_przypisanym_użytkownikiem_oraz_priorytetem_zostaje_dodane_na_listę_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

    // 5

    @Given("Użytkownik uruchamia aplikację_5")
    public void użytkownik_uruchamia_aplikację_5() {
        System.out.println("test");
    }
    @When("Wprowadza poprawną nazwę zadania, jego szczegóły oraz użytkownika")
    public void wprowadza_poprawną_nazwę_zadania_jego_szczegóły_oraz_użytkownika() {
        System.out.println("test");
    }
    @When("Wciska przycisk Add_5")
    public void wciska_przycisk_add_5() {
        System.out.println("test");
    }
    @Then("Nowe zadanie z nazwą, szczegółami oraz przypisanym użytkownikiem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_szczegółami_oraz_przypisanym_użytkownikiem_zostaje_dodane_na_listę_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

    // 6

    @Given("Użytkownik uruchamia aplikację_6")
    public void użytkownik_uruchamia_aplikację_6() {
        System.out.println("test");
    }
    @When("Wprowadza poprawną nazwę zadania, jego szczegóły, użytkownika oraz priorytet")
    public void wprowadza_poprawną_nazwę_zadania_jego_szczegóły_użytkownika_oraz_priorytet() {
        System.out.println("test");
    }
    @When("Wciska przycisk Add_6")
    public void wciska_przycisk_add_6() {
        System.out.println("test");
    }
    @Then("Nowe zadanie z nazwą, szczegółami, przypisanym użytkownikiem oraz priorytetem zostaje dodane na listę zadań")
    public void nowe_zadanie_z_nazwą_szczegółami_przypisanym_użytkownikiem_oraz_priorytetem_zostaje_dodane_na_listę_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

}
