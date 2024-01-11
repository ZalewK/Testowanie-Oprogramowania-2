package testowanie.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import pw.testowanie.TestowanieApplication;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = TestowanieApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    WebDriver driver;

    @LocalServerPort
    private int port;
    private final String host = "http://localhost:";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        clearTasksForTesting();
    }

    @AfterEach
    public void tearDown() {
        clearTasksForTesting();
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddTask() {
        // given
        driver.get(host + port);
        String taskName = "task";

        //when
        addTask(taskName, "details", "user", "HIGH");

        // then
        WebElement addedTaskName = driver.findElement(By.xpath("//td[text()='" + taskName + "']"));

        assertEquals(taskName, addedTaskName.getText());
    }

    @Test
    public void testChangeTaskStatus() {
        // given
        driver.get(host + port);
        addTask("task", "", "", "HIGH");
        WebElement beforeUpdateTaskStatusElement = driver.findElement(By.xpath("//tbody/tr/td[4]"));
        String beforeUpdateTaskStatusElementText = beforeUpdateTaskStatusElement.getText();

        // when
        WebElement changeStatusButton = driver.findElement(By.className("change-button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", changeStatusButton);

        // then
        WebElement updatedTaskStatus = driver.findElement(By.xpath("//tbody/tr/td[4]"));

        assertEquals("IN_PROGRESS", beforeUpdateTaskStatusElementText);
        assertEquals("COMPLETED", updatedTaskStatus.getText());
    }

    @Test
    public void testDeleteTask() {
        // given
        driver.get(host + port);
        addTask("programming", "", "", "HIGH");

        // when
        WebElement deleteButton = driver.findElement(By.className("delete-button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", deleteButton);

        // then
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tbody/tr")));

        assertFalse(driver.getPageSource().contains("programming"));
    }

    @Test
    public void testSortTasksByName() {
        // given
        driver.get(host + port);
        WebElement addButton = driver.findElement(By.className("add-button"));
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("Cleaning");

        addButton.click();

        WebElement nameInput2 = driver.findElement(By.id("name"));
        WebElement addButton2 = driver.findElement(By.className("add-button"));
        nameInput2.sendKeys("Gardening");
        addButton2.click();

        // when
        WebElement sortByNameButton = driver.findElement(By.xpath("//button[@value='name']"));
        sortByNameButton.click();

        // then
        WebElement firstTaskName = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        WebElement secondTaskName = driver.findElement(By.xpath("//tbody/tr[2]/td[1]"));

        assertEquals("Cleaning", firstTaskName.getText());
        assertEquals("Gardening", secondTaskName.getText());
    }

    @Test
    public void testSortTasksByUser() {
        // given
        driver.get(host + port);
        addTask("Cleaning", "", "Adam", "MEDIUM");
        addTask("Gardening", "", "Eve", "MEDIUM");

        // when
        WebElement sortByNameButton = driver.findElement(By.xpath("//button[@value='user']"));
        sortByNameButton.click();

        // then
        WebElement firstTask = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        WebElement secondTask = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
        assertEquals("Adam", firstTask.getText());
        assertEquals("Eve", secondTask.getText());
    }

    @Test
    public void testSortTasksByPriority() {
        // given
        driver.get(host + port);
        addTask("Task1", "", "", "HIGH");
        addTask("Task2", "", "", "MEDIUM");
        addTask("Task3", "", "", "LOW");

        // when
        WebElement sortByPriorityButton = driver.findElement(By.xpath("//button[@value='priority']"));
        sortByPriorityButton.click();

        // then
        WebElement firstTaskPriority = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        WebElement secondTaskPriority = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
        WebElement thirdTaskPriority = driver.findElement(By.xpath("//tbody/tr[3]/td[3]"));

        assertEquals("HIGH", firstTaskPriority.getText());
        assertEquals("MEDIUM", secondTaskPriority.getText());
        assertEquals("LOW", thirdTaskPriority.getText());
    }

    @Test
    public void testSortTasksByStatus() {
        // given
        driver.get(host + port);
        addTask("test", "", "", "HIGH");
        addTask("test", "", "", "HIGH");
        addTask("test", "", "", "HIGH");
        WebElement changeStatusButton = driver.findElement(By.className("change-button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", changeStatusButton);

        // when
        WebElement sortByStatusButton = driver.findElement(By.xpath("//button[@value='status']"));
        sortByStatusButton.click();

        // then
        WebElement firstTaskStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[4]"));
        WebElement secondTaskStatus = driver.findElement(By.xpath("//tbody/tr[2]/td[4]"));
        WebElement thirdTaskStatus = driver.findElement(By.xpath("//tbody/tr[3]/td[4]"));

        assertEquals("IN_PROGRESS", firstTaskStatus.getText());
        assertEquals("IN_PROGRESS", secondTaskStatus.getText());
        assertEquals("COMPLETED", thirdTaskStatus.getText());
    }

    @Test
    public void testSearchByUserName() {
        // given
        driver.get(host + port);
        addTask("Drawing", "", "John Doe", "HIGH");
        addTask("Playing", "", "Jane Doe", "MEDIUM");

        // when
        WebElement userNameInput = driver.findElement(By.id("userName"));
        WebElement searchButton = driver.findElement(By.className("search-button"));

        userNameInput.sendKeys("John");
        searchButton.click();

        // then
        WebElement foundTaskUser = driver.findElement(By.xpath("//tbody/tr/td[text()='Drawing']" +
                "/following-sibling::td[1]"));
        assertEquals("John Doe", foundTaskUser.getText());
    }

    @Test
    public void testSearchByTaskName() {
        // given
        driver.get(host + port);
        addTask("Clearing", "", "John Doe", "HIGH");
        addTask("Cloning", "", "Jane Doe", "MEDIUM");

        // when
        WebElement taskNameInput = driver.findElement(By.id("taskName"));
        WebElement searchButton = driver.findElement(By.className("search-button"));

        taskNameInput.sendKeys("Clo");
        searchButton.click();

        // then
        WebElement foundTask = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        assertEquals("Cloning", foundTask.getText());
    }

    @Test
    public void testRedirectToDetailsPage() {
        // given
        driver.get(host + port);
        addTask("TaskToDetail", "veryimportantdetail", "John Doe", "MEDIUM");

        // when
        WebElement detailsButton = driver.findElement(By.className("details-button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", detailsButton);

        // then
        WebElement taskDetailsHeader = driver.findElement(By.tagName("h1"));
        assertEquals("Task Details", taskDetailsHeader.getText());

        WebElement taskDetailsText = driver.findElement(By.xpath("//div/p/strong[text()='Details:']/following-sibling::span"));
        assertEquals("veryimportantdetail", taskDetailsText.getText());

        WebElement backButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        backButton.click();

        WebElement taskListHeader = driver.findElement(By.tagName("h1"));
        assertEquals("To Do", taskListHeader.getText());
    }

    private void addTask(String name, String details, String user, String priority) {
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement detailsInput = driver.findElement(By.id("details"));
        WebElement userInput = driver.findElement(By.id("user"));
        WebElement prioritySelect = driver.findElement(By.id("priority"));
        WebElement addButton = driver.findElement(By.className("add-button"));

        nameInput.sendKeys(name);
        detailsInput.sendKeys(details);
        userInput.sendKeys(user);
        prioritySelect.sendKeys(priority);

        addButton.click();
    }

    private void clearTasksForTesting() {
        driver.get(host + port + "/clearTasksForTesting");
    }
}
