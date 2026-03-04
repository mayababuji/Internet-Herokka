package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DisappearingElementPage {
    private static final String ALL_ELEMENTS = "ul li a";
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DisappearingElementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public List<String> getMenuItems() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(ALL_ELEMENTS)));
        List<WebElement> menuItems = driver.findElements(By.cssSelector(ALL_ELEMENTS));
        List<String> menuItemNames = new ArrayList<>();
        menuItems.forEach(menuItem -> {
            menuItemNames.add(menuItem.getText());
        });
        return menuItemNames;
    }


}
