package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private final WebDriver driver;
    // Using CSS Selector for testing
    private static final String JSALERT_BUTTON = "button[onclick='jsAlert()']";
    private static final String RESULT_ID = "result";
    private static final String JSCONFIRM_BUTTON = "button[onclick='jsConfirm()']";
    private static final String JSPROMPT_BUTTON = "button[onclick='jsPrompt()']";


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

    public void triggerConfirmAlert() {
        driver.findElement(By.cssSelector(JSCONFIRM_BUTTON)).click();
    }
    public void triggerPromptAlert() {
        driver.findElement(By.cssSelector(JSPROMPT_BUTTON)).click();
    }
    public void enterPrompt(String prompt) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(prompt);
        String promptText = alert.getText();
        alert.accept();


    }
}
