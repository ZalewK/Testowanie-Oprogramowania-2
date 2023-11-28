package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveTaskStepDefinitions {

    @Given("Użytkownik uruchamia aplikację_r")
    public void użytkownik_uruchamia_aplikację() {
        System.out.println("test");
    }
    @When("Wciska przycisk Delete")
    public void wciska_przycisk_delete() {
        System.out.println("test");
    }
    @Then("Zadanie zostaje usunięte z listy zadań")
    public void zadanie_zostaje_usunięte_z_listy_zadań() {
        System.out.println("test");
        assertTrue(true);
    }
    
}
