package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public AlertsPage clickAlertsLink(){
        clickLink("a[href*='alerts']");
        return new AlertsPage(driver);
    }

    private void clickLink(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

}
