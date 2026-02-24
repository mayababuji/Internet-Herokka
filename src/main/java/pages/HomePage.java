package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private static final String JSALERTS = "a[href*='alerts']";
    private static final String ADDREMOVELEM="a[href*='remove']";

    private WebDriverWait wait;
    public HomePage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public AlertsPage clickAlertsLink(){
        // Wait until the link is clickable to avoid timing issues
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(JSALERTS)))
                .click();
        return new AlertsPage(driver);
    }

    public AddRemoveElemPage clickAddRemoveLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ADDREMOVELEM))).click();
        return new AddRemoveElemPage(driver);


    }


}
