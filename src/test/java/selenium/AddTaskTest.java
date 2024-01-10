package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import java.util.Optional;
import org.openqa.selenium.devtools.v120.network.model.Response;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.RequestId;

public class AddTaskTest {

    @Test
    public void addTestas() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        // devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
        //     Request request = requestConsumer.getRequest();
        //     System.out.println(request.getUrl());
        // });

        // final RequestId[] requestId = new RequestId[1];

        // devTools.addListener(Network.responseReceived(), responseConsumer -> {
        //     Response response = responseConsumer.getResponse();
        //     requestId[0] = responseConsumer.getRequestId();
        //     if (response.getUrl().contains("/addTask")) {
        //         System.out.println(response.getStatus() + " " + response.getUrl());
        //         String responseBody = devTools.send(Network.getResponseBody(requestId[0])).getBody();
        //         System.err.println(responseBody);
        //     }

        // });

        driver.get("http://localhost:8080/");
        // WebElement taskNameInput = driver.findElement(By.id("name"));
        // taskNameInput.sendKeys("Nowe Zadanie");
        // WebElement addButton = driver.findElement(By.cssSelector(".add-button"));
        // addButton.click();

    }
}
