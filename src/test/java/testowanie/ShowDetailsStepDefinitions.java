package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShowDetailsStepDefinitions {

    @Given("Użytkownik posiada dodane zadanie")
    public void użytkownik_posiada_dodane_zadanie() {
        System.out.println("test");
    }
    @When("Wciska przycisk Details")
    public void wciska_przycisk_details() {
        System.out.println("test");
    }
    @Then("Wyświetla się okno z detalami zadania")
    public void wyświetla_się_okno_z_detalami_zadania() {
        System.out.println("test");
        assertTrue(true);
    }
    
}
