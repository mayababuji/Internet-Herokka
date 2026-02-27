package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Locators

    private static final String HOT_SPOT = "hot-spot";
    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnContextMenu() {
        WebElement hotspot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HOT_SPOT)));
        Actions actions = new Actions(driver);
        actions.contextClick(hotspot).perform();

    }

    public String validateClickOnContextMenu() {

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;

    }

}
