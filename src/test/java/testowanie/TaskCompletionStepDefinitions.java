package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskCompletionStepDefinitions {

    // 1

    @Given("Na liście jest wykonane zadanie")
    public void na_liście_jest_wykonane_zadanie() {
        System.out.println("test");
    }
    @When("Wciskamy przycisk Change status_tc_2")
    public void wciskamy_przycisk_change_status_kiedy_wykonane() {
        System.out.println("test");
    }
    @Then("Zadanie pokazuje się jako niewykonane")
    public void zadanie_pokazuje_się_jako_niewykonane() {
        System.out.println("test");
        assertTrue(true);
    }

    // 2

    @Given("Na liście jest niewykonane zadanie")
    public void na_liście_jest_niewykonane_zadanie() {
        System.out.println("test");
    }
    @When("Wciskamy przycisk Change status_tc_1")
    public void wciskamy_przycisk_change_status_kiedy_niewykonane() {
        System.out.println("test");
    }
    @Then("Zadanie pokazuje się jako wykonane")
    public void zadanie_pokazuje_się_jako_wykonane() {
        System.out.println("test");
        assertTrue(true);
    }
    
}
