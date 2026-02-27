package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Locator
    private static final String CHECKBOXES = "input[type='checkbox']";
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnFirstCheckBox(){
        List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CHECKBOXES)));

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            break;
        }

    }

    public boolean validateClickOnFirstCheckBox(){
        List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CHECKBOXES)));
        boolean firstCheckBoxIsselectted = checkboxes.get(0).isSelected();
        return firstCheckBoxIsselectted;

    }
    public void clickOnSecondCheckBox(){
        List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CHECKBOXES)));
        checkboxes.get(1).click();


    }
    public boolean validateSecondCheckBox(){
        List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CHECKBOXES)));
        boolean secondCheckBoxNotselectted = (!checkboxes.get(1).isSelected());
        return secondCheckBoxNotselectted;
    }


}
