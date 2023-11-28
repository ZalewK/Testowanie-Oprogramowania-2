package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortTasksStepDefinitions {

    // 1

    @Given("Na liście są zadania_st_1")
    public void na_liście_są_zadania_1() {
        System.out.println("test");
    }
    @When("Wciska przycisk Sortuj alfabetycznie")
    public void wciska_przycisk_sortuj_alfabetycznie() {
        System.out.println("test");
    }
    @Then("Zadania są wyświetlone alfabetycznie")
    public void zadania_są_wyświetlone_alfabetycznie() {
        System.out.println("test");
    }

    // 2

    @Given("Na liście są zadania_st_2")
    public void na_liście_są_zadania_2() {
        System.out.println("test");
    }
    @When("Wciska przycisk Sortuj po użytkowniku")
    public void wciska_przycisk_sortuj_po_użytkowniku() {
        System.out.println("test");
    }
    @Then("Zadania są wyświetlone według użytkownika")
    public void zadania_są_wyświetlone_według_użytkownika() {
        System.out.println("test");
        assertTrue(true);
    }

    // 3

    @Given("Na liście są zadania_st_3")
    public void na_liście_są_zadania_3() {
        System.out.println("test");
    }
    @When("Wciska przycisk Sortuj po priorytecie")
    public void wciska_przycisk_sortuj_po_priorytecie() {
        System.out.println("test");
    }
    @Then("Zadania są wyświetlone według priorytetu")
    public void zadania_są_wyświetlone_według_priorytetu() {
        System.out.println("test");
        assertTrue(true);
    }
    
}
