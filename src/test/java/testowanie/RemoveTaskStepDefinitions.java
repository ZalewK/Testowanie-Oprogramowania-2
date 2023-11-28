package testowanie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;

import java.util.List;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import pw.testowanie.TaskController;
import pw.testowanie.Task;
import pw.testowanie.Priority;

public class RemoveTaskStepDefinitions {

    String taskName;
    String userName;
    TaskController taskController;
    String viewName;
    ExtendedModelMap model;
    private List<Task> tasksBeforeDeletion;
    private int numOfTasksBeforeDeletion;
    private int numOfTasksAfterDeletion;

    @Given("Użytkownik uruchamia aplikację_r")
    public void użytkownik_uruchamia_aplikację() {
        
        taskController = new TaskController();
        List<Task> taskList = taskController.getTasks();
        if (taskList.size() == 0) {
            Task task1 = new Task("Nowe Zadanie 1", "", "", Priority.LOW);
            taskController.addTaskDirectly(task1);
            Task task2 = new Task("Nowe Zadanie 2", "", "", Priority.LOW);
            taskController.addTaskDirectly(task2);
        }

        tasksBeforeDeletion = taskController.getTasks();
        numOfTasksBeforeDeletion = tasksBeforeDeletion.size();
    }
    @When("Wciska przycisk Delete")
    public void wciska_przycisk_delete() {

        long taskIdToDelete = tasksBeforeDeletion.get(1).getId();
        taskController.deleteTask(taskIdToDelete);

        taskName = "Nowe Zadanie 2";

        Model model = new ExtendedModelMap();
        String viewName = taskController.searchTasks("", taskName, model);

        this.model = (ExtendedModelMap) model;
        this.viewName = viewName;
    }
    @Then("Zadanie zostaje usunięte z listy zadań")
    public void zadanie_zostaje_usunięte_z_listy_zadań() {

        List<Task> tasksAfterDeletion = taskController.getTasks();
        numOfTasksAfterDeletion = tasksAfterDeletion.size();

        List<Task> filteredTasks = (List<Task>) model.getAttribute("tasks");
        boolean allMatch = filteredTasks.stream().anyMatch(task -> task.getName().contains(taskName));


        assertEquals(numOfTasksBeforeDeletion - 1, numOfTasksAfterDeletion);

        assertFalse(allMatch, "All tasks should have names containing the search term");
        assertTrue(filteredTasks.size() == 0, "There should be only one task with the given user name");


    }
    
}