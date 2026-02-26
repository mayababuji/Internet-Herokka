package challengingDOM;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ChallengingDOMPage;
import pages.HomePage;

public class ChallengingDOMTest extends BaseTest {
    @BeforeMethod
    public void goToChallengingDOMPages(){
        getDriver().get("https://the-internet.herokuapp.com");
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }

    @Feature("Challenging DOM")
    @Epic("User CLicks on Challenging DOM link")
    @Test(description = "Verify if the blue button is clicked")
    public void clickChallengingDOMBlueLink(){
        ChallengingDOMPage challengingDOMPage = new HomePage(getDriver()).clickChallengingDOMLink();
        String canvasTextBefore = challengingDOMPage.canvasString();
        challengingDOMPage.clickBlueButton();
        String canvasTextAfter = challengingDOMPage.canvasString();
        boolean isCanavsTextEqual = challengingDOMPage.isCanvasTextEqual(canvasTextBefore,canvasTextAfter);
        Assert.assertTrue(isCanavsTextEqual);
    }

    @Test(description = "Verify if the Red button is clicked")
    public void clickChallengingDOMRedLink(){
        ChallengingDOMPage challengingDOMPage = new HomePage(getDriver()).clickChallengingDOMLink();
        String canvasTextBefore = challengingDOMPage.canvasString();
        challengingDOMPage.clickRedButton();
        String canvasTextAfter = challengingDOMPage.canvasString();
        boolean isCanavsTextEqual = challengingDOMPage.isCanvasTextEqual(canvasTextBefore,canvasTextAfter);
        Assert.assertTrue(isCanavsTextEqual);
    }

    @Test(description = "Verify if the Green button is clicked")
    public void clickChallengingDOMGreenLink(){
        ChallengingDOMPage challengingDOMPage = new HomePage(getDriver()).clickChallengingDOMLink();
        String canvasTextBefore = challengingDOMPage.canvasString();
        challengingDOMPage.clickGreenButton();
        String canvasTextAfter = challengingDOMPage.canvasString();
        boolean isCanavsTextEqual = challengingDOMPage.isCanvasTextEqual(canvasTextBefore,canvasTextAfter);
        Assert.assertTrue(isCanavsTextEqual);
    }

}
