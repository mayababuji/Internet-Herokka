package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    // Using CSS Selector for testing
    private static final String JSALERT_BUTTON = "button[onclick='jsAlert()']";
    private static final String RESULT_ID = "result";
    private static final String JSCONFIRM_BUTTON = "button[onclick='jsConfirm()']";
    private static final String JSPROMPT_BUTTON = "button[onclick='jsPrompt()']";


    public AlertsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void triggerAlert() {
        driver.findElement(By.cssSelector(JSALERT_BUTTON)).click();
    }

    public void acceptAlert() {
        // Wait for alert to be present before accepting

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getResultMessage() {
        // Wait for the result element to be visible

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(RESULT_ID)));
        return driver.findElement(By.id(RESULT_ID)).getText();
    }

    public void triggerConfirmAlert() {
        driver.findElement(By.cssSelector(JSCONFIRM_BUTTON)).click();
    }
    public void triggerPromptAlert() {
        driver.findElement(By.cssSelector(JSPROMPT_BUTTON)).click();
    }
    public void enterPrompt(String prompt) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(prompt);
        alert.accept();

    }
}
