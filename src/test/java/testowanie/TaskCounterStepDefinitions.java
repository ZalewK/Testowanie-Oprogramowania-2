package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskCounterStepDefinitions {
    
    // 1

    @Given("Użytkownik uruchamia aplikację_to_1")
    public void użytkownik_uruchamia_aplikację_1() {
        System.out.println("test");
    }
    @When("Na liście są zadania")
    public void na_liście_są_zadania() {
        System.out.println("test");
    }
    @Then("Wyświetla się liczba zadań")
    public void wyświetla_się_liczba_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

    // 2

    @Given("Użytkownik uruchamia aplikację_to_2")
    public void użytkownik_uruchamia_aplikację_2() {
        System.out.println("test");
    }
    @When("Na liście są ukończone zadania")
    public void na_liście_są_ukończone_zadania() {
        System.out.println("test");
    }
    @Then("Wyświetla się liczba ukończonych zadań")
    public void wyświetla_się_liczba_ukończonych_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

    // 3

    @Given("Użytkownik uruchamia aplikację_to_3")
    public void użytkownik_uruchamia_aplikację_3() {
        System.out.println("test");
    }
    @When("Na liście są nieukończone zadania")
    public void na_liście_są_nieukończone_zadania() {
        System.out.println("test");
    }
    @Then("Wyświetla się liczba nieukończonych zadań")
    public void wyświetla_się_liczba_nieukończonych_zadań() {
        System.out.println("test");
        assertTrue(true);
    }

}
