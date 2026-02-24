package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddRemoveElemPage {
    private final WebDriver driver;
    private  WebDriverWait wait;

    //LOCATORS CSS
    private static final String ADD_REMOVE_BUTTON = "button[onclick='addElement()']";
    private static final String REMOVE_ELEMENT = "button.added-manually";



    public AddRemoveElemPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAddRemoveElement(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ADD_REMOVE_BUTTON)));
        driver.findElement(By.cssSelector(ADD_REMOVE_BUTTON)).click();
    }

    public  int getDeleteButtonCount(){

        List<WebElement> deleteElems= driver.findElements(By.cssSelector(REMOVE_ELEMENT));
        int size = deleteElems.size();
        return size;

    }

    public void clickOnDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REMOVE_ELEMENT)));
        List<WebElement> deleteElems= driver.findElements(By.cssSelector(REMOVE_ELEMENT));
        for(int i=0;i<deleteElems.size();i++){
            deleteElems.get(i).click();
        }


    }





}
