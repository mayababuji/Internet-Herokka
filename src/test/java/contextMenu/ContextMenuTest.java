package contextMenu;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.HomePage;

public class ContextMenuTest extends BaseTest {
    @BeforeMethod
    public void goToContextMenuPages(){
        getDriver().get("https://the-internet.herokuapp.com");
        System.out.println("Running thread: " + Thread.currentThread().getName());

    }

    @Epic("Context Menu")
    @Feature("User clicks on context menu")
    @Test(description = "Verify if context menu is clicked")
    public void contextMenuIsClicked(){
        ContextMenuPage contextMenuPage = new HomePage(getDriver()).clickContextMenuLink();
contextMenuPage.clickOnContextMenu();
String alertText = contextMenuPage.validateClickOnContextMenu();
String expectedString = "You selected a context menu";
Assert.assertEquals(alertText,expectedString);
    }
}
