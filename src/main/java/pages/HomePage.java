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
    private static final String BROKEN_IMAGES_LINK = "a[href*='broken_images']";
    private static final String CHALLENGING_DOM = "a[href*='challenging']";
    private static final String CHECK_BOX_LINK = "a[href*='checkboxes']";
    private static final String CONTEXT_MENU_LINK = "a[href*='context']";

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

    public BrokenImagesPage clickBrokenImagesLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BROKEN_IMAGES_LINK)));
        driver.findElement(By.cssSelector(BROKEN_IMAGES_LINK)).click();
        return new BrokenImagesPage(driver);
    }

    public ChallengingDOMPage   clickChallengingDOMLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHALLENGING_DOM)));
        driver.findElement(By.cssSelector(CHALLENGING_DOM)).click();
        return new ChallengingDOMPage(driver);
    }

    public CheckBoxPage clickCheckBoxLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHECK_BOX_LINK))).click();
        return new CheckBoxPage(driver);

    }

    public ContextMenuPage clickContextMenuLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CONTEXT_MENU_LINK))).click();
        return new ContextMenuPage(driver);

    }


}
