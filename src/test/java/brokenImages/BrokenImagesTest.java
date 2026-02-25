package brokenImages;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.BrokenImagesPage;
import pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
@Epic("HerokuApp")
public class BrokenImagesTest  extends BaseTest
{
    @BeforeMethod
    public void goToBrokenImagesPage()
    {
        getDriver().get("https://the-internet.herokuapp.com");

        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
    @Feature("Broken Images")
    @Story("User clicks on broken Images")
    @Test(description = "Verify the number of broken images")
    public void brokenImagesTest()
    {
        int actualCount = 2;
        BrokenImagesPage brokenImagesPage = new HomePage(getDriver()).clickBrokenImagesLink();
        List<String> brokenImages =  brokenImagesPage.getBrokenImages();
        System.out.println("The broken image are " + brokenImages);
        assertEquals(brokenImages.size(), actualCount,"Expected number of broken images is not correct");

    }
}
