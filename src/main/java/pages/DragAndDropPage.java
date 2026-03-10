package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    //Locator
    private static final String ELEMENT_A = "#column-a";
    private static final String ELEMENT_B = "#column-b";

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public WebElement getElementA() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ELEMENT_A)));
        return driver.findElement(By.cssSelector(ELEMENT_A));

    }

    public WebElement getElementB() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ELEMENT_B)));
        return driver.findElement(By.cssSelector(ELEMENT_B));
    }

    public void dragAndDrop() {
        Actions dragDropAct = new Actions(driver);
        dragDropAct.dragAndDrop(getElementA(), getElementB()).build().perform();



    }
    public String getColumnAText() {
        return getElementA().getText();
    }

    public String getColumnBText() {
        return getElementB().getText();
    }
}

