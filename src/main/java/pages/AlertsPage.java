package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private final WebDriver driver;
    // Using CSS Selector for testing
    private static final String JSALERT_BUTTON = "button[onclick='jsAlert()']";
    private static final String RESULT_ID = "result";

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(By.cssSelector(JSALERT_BUTTON)).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getResultMessage() {
        return driver.findElement(By.id(RESULT_ID)).getText();
    }
}
