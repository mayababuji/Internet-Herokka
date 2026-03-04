package disappearingElements;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DisappearingElementPage;
import pages.HomePage;

import java.util.List;

public class DisappearingElementTest extends BaseTest {


@Epic("Disapperring Menu")
@Feature("User clicks on disaapearing elements")
    @Test(description = "Test if Gallery element is disappeared")
    public void clickDisappearingElement()
    {
        DisappearingElementPage disappearingElementPage = new HomePage(getDriver()).clickDisappearingElementLink();
        System.out.println("The list of visible elements are "+disappearingElementPage.getMenuItems());

        List<String> names = disappearingElementPage.getMenuItems();
        if(!names.contains("Gallery")){
            System.out.println("Gallery is not displayed");
        }

        Assert.assertTrue(!names.contains("Gallery"));

    }

    @Test(description = "Test if Gallery element reappears after a refresh")
    public void clickNotDisappearingElement()
    {
        DisappearingElementPage disappearingElementPage = new HomePage(getDriver()).clickDisappearingElementLink();
        System.out.println("The list of visible elements are "+disappearingElementPage.getMenuItems());
getDriver().navigate().refresh();
        List<String> names = disappearingElementPage.getMenuItems();
        if(names.contains("Gallery")){
            System.out.println("Gallery is  displayed");
        }

        Assert.assertTrue(names.contains("Gallery"));

    }
}
