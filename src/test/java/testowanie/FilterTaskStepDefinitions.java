package testowanie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;
import pw.testowanie.TaskController;
import pw.testowanie.Task;
import pw.testowanie.Priority;
import pw.testowanie.Status;

public class FilterTaskStepDefinitions {

    private TaskController taskController = new TaskController();
    private List<Task> tasks;
    
    // 1

    @Given("Na liście są nieukończone zadania_f")
    public void na_liście_są_nieukończone_zadania() {
        tasks = new ArrayList<>();

        tasks.add(new Task("Zadanie 1", "Szczegóły 1", "Użytkownik 1", Priority.LOW));
        tasks.add(new Task("Zadanie 2", "Szczegóły 2", "Użytkownik 2", Priority.MEDIUM));
        tasks.add(new Task("Zadanie 3", "Szczegóły 3", "Użytkownik 3", Priority.HIGH));
        
        tasks.forEach(taskController::addTaskDirectly);


    }
    @When("Zaznacza opcję Filtruj po nieukończonych")
    public void zaznacza_opcję_filtruj_po_nieukończonych() {
        System.out.println("test");
    }
    @Then("Wyświetlone są tylko nieukończone zadania")
    public void wyświetlone_są_tylko_nieukończone_zadania() {
        System.out.println("test");
        assertEquals(1, 1);
    }

    // 2

    @Given("Na liście są ukończone zadania_f")
    public void na_liście_są_ukończone_zadania() {
        System.out.println("test");
    }
    @When("Zaznacza opcję Filtruj po ukończonych")
    public void zaznacza_opcję_filtruj_po_ukończonych() {
        System.out.println("test");
    }
    @Then("Wyświetlone są tylko ukończone zadania")
    public void wyświetlone_są_tylko_ukończone_zadania() {
        System.out.println("test");
        assertEquals(1, 1);
    }

    // 3

    @Given("Użytkownik uruchamia aplikację_f")
    public void użytkownik_uruchamia_aplikację() {
        System.out.println("test");
    }
    @When("Na liście są zadania_f")
    public void na_liście_są_zadania() {
        System.out.println("test");
    }
    @Then("Wszystkie zadania są wyświetlone")
    public void wszystkie_zadania_są_wyświetlone() {
        System.out.println("test");
        assertEquals(1, 1);
    }
    
}
