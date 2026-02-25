package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAuthPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    // Using CSS Selector for testing
    private static final String LOGIN_MESSAGE = "p";

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getSuccessMessage() {
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOGIN_MESSAGE))).getText();
        return message;

    }


}
