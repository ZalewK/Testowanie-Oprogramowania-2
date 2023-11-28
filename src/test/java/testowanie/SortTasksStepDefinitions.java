package testowanie;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pw.testowanie.Priority;
import pw.testowanie.Task;
import pw.testowanie.TaskController;

public class SortTasksStepDefinitions {

    TaskController taskController = new TaskController();

    @Given("Na liście są zadania_st_1")
    public void na_liście_są_zadania_1() {
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
            taskController.addTaskDirectly(task3);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
            taskController.addTaskDirectly(task2);
        }
    }

    @When("Wciska przycisk Sortuj alfabetycznie")
    public void wciska_przycisk_sortuj_alfabetycznie() {
        taskController.sort("name");
    }

    @Then("Zadania są wyświetlone alfabetycznie")
    public void zadania_są_wyświetlone_alfabetycznie() {
        List<Task> sortedTasks = taskController.getTasks();
        assertTrue(isSortedByName(sortedTasks));
    }

    @Given("Na liście są zadania_st_2")
    public void na_liście_są_zadania_2() {
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
            taskController.addTaskDirectly(task3);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
            taskController.addTaskDirectly(task2);
        }
    }

    @When("Wciska przycisk Sortuj po użytkowniku")
    public void wciska_przycisk_sortuj_po_użytkowniku() {
        taskController.sort("user");
    }

    @Then("Zadania są wyświetlone według użytkownika")
    public void zadania_są_wyświetlone_według_użytkownika() {
        List<Task> sortedTasks = taskController.getTasks();
        assertTrue(isSortedByUser(sortedTasks));
    }

    @Given("Na liście są zadania_st_3")
    public void na_liście_są_zadania_3() {
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Task Name 1", "Details 1", "User 1", Priority.HIGH);
            taskController.addTaskDirectly(task1);
            Task task3 = new Task("Task Name 3", "Details 3", "User 3", Priority.LOW);
            taskController.addTaskDirectly(task3);
            Task task2 = new Task("Task Name 2", "Details 2", "User 2", Priority.MEDIUM);
            taskController.addTaskDirectly(task2);
        }

    }

    @When("Wciska przycisk Sortuj po priorytecie")
    public void wciska_przycisk_sortuj_po_priorytecie() {
        taskController.sort("priority");
    }

    @Then("Zadania są wyświetlone według priorytetu")
    public void zadania_są_wyświetlone_według_priorytetu() {
        List<Task> sortedTasks = taskController.getTasks();
        assertTrue(isSortedByPriority(sortedTasks));
    }

    private boolean isSortedByName(List<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            if (tasks.get(i).getName().compareToIgnoreCase(tasks.get(i + 1).getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedByUser(List<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            if (tasks.get(i).getUser().compareToIgnoreCase(tasks.get(i + 1).getUser()) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedByPriority(List<Task> taskController) {
        for (int i = 0; i < taskController.size() - 1; i++) {
            if (taskController.get(i).getPriority().compareTo(taskController.get(i + 1).getPriority()) > 0) {
                return false;
            }
        }
        return true;
    }

}
