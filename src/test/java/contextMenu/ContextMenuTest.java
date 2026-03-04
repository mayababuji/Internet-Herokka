package contextMenu;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.HomePage;

@Epic("HerokuApp")
public class ContextMenuTest extends BaseTest {


    @Feature("Context Menu")
    @Story("User clicks on context menu")
    @Test(description = "Verify if context menu is clicked")
    public void contextMenuIsClicked() {
        ContextMenuPage contextMenuPage = new HomePage(getDriver()).clickContextMenuLink();
        contextMenuPage.clickOnContextMenu();
        String alertText = contextMenuPage.validateClickOnContextMenu();
        String expectedString = "You selected a context menu";
        Assert.assertEquals(alertText, expectedString);
    }
}
