package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage {
    private WebDriver driver;
    private  WebDriverWait wait;

    // Using CSS Selector for testing

    private static final String IMAGES = "img[src$='jpg']";
    public BrokenImagesPage(WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

public List getBrokenImages() {
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(IMAGES)));
    List<WebElement> images = driver.findElements(By.cssSelector(IMAGES));
    List<String> brokenImagesList = new ArrayList<>();
    for (WebElement image : images) {
        String imgSrc = image.getAttribute("src");
        boolean isImageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].naturalWidth>0;", image);

        if (!isImageLoaded) {
            brokenImagesList.add(imgSrc);
           // System.out.println("The broken image is " + imgSrc);
        }
    }
    return brokenImagesList;
}


}
