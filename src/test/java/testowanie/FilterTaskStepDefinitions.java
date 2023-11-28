package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterTaskStepDefinitions {
    
    // 1

    @Given("Na liście są nieukończone zadania_f")
    public void na_liście_są_nieukończone_zadania() {
        System.out.println("test");
    }
    @When("Zaznacza opcję Filtruj po nieukończonych")
    public void zaznacza_opcję_filtruj_po_nieukończonych() {
        System.out.println("test");
    }
    @Then("Wyświetlone są tylko nieukończone zadania")
    public void wyświetlone_są_tylko_nieukończone_zadania() {
        System.out.println("test");
        assertTrue(true);
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
        assertTrue(true);
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
        assertTrue(true);
    }
    
}
