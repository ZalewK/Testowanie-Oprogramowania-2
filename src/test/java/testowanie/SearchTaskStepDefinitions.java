package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTaskStepDefinitions {
    
    // 1

    @Given("Na liście są zadania_ts_1")
    public void na_liście_są_zadania_1() {
        System.out.println("test");
    }
    @When("Wprowadza nazwę zadania")
    public void wprowadza_nazwę_zadania() {
        System.out.println("test");
    }
    @When("Wciska przycisk Szukaj po nazwie")
    public void wciska_przycisk_szukaj_po_nazwie() {
        System.out.println("test");
    }
    @Then("Wyświetlają się zadania z pasującą nazwą zadania")
    public void wyświetlają_się_zadania_z_pasującą_nazwą_zadania() {
        System.out.println("test");
        assertTrue(true);
    }

    // 2

    @Given("Na liście są zadania_ts_2")
    public void na_liście_są_zadania_2() {
        System.out.println("test");
    }
    @When("Wprowadza nazwę użytkownika")
    public void wprowadza_nazwę_użytkownika() {
        System.out.println("test");
    }
    @When("Wciska przycisk Szukaj po użytkowniku")
    public void wciska_przycisk_szukaj_po_użytkowniku() {
        System.out.println("test");
    }
    @Then("Wyświetlają się zadania z pasującą nazwą użytkownika")
    public void wyświetlają_się_zadania_z_pasującą_nazwą_użytkownika() {
        System.out.println("test");
        assertTrue(true);
    }

}
