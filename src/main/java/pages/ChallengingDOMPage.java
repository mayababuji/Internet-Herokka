package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ChallengingDOMPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public ChallengingDOMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    // Using CSS Selector for testing
    private static final String BLUEBUTTON = "a.button:not(.alert):not(.success)";
    private static final String CANVAS_SCRIPT = "//script[contains(text(),'canvas')]";
    private static final String INNER_HTML ="innerHTML";
    private static final String GREENBUTTON ="a.button.success";
    private static final String REDBUTTON ="a.button.alert";

    public void clickBlueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BLUEBUTTON))).click();

    }
    public void clickGreenButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(GREENBUTTON))).click();

    }
    public void clickRedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REDBUTTON))).click();

    }
public String canvasString(){
        /*
        The wait failed because <script> tags are never visible,
        so removing it allowed Selenium to read the script’s innerHTML directly.
         */
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CANVAS_SCRIPT)));
    String canvasText = driver.findElement(By.xpath(CANVAS_SCRIPT)).getAttribute(INNER_HTML);
    return canvasText;
}

public boolean isCanvasTextEqual(String canvasTextBefore,String canvasTextAfter){
        return (!canvasTextBefore.equals(canvasTextAfter));
}
}
