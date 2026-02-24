package alerts;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTest {

    @BeforeMethod
    public void goToAlertPage(){
        getDriver().get("https://the-internet.herokuapp.com");

        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
    @Epic("HerokuApp")
    @Feature("JavaScript Alert")
    @Story("User JavaScript Alert button")
    @Test(description = "Verify JavaScript Alert functionality")
    public void testAlert(){
        AlertsPage alertPage = new HomePage(getDriver()).clickAlertsLink();
        alertPage.triggerAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultMessage(), "You successfully clicked an alert", "Result message is incorrect");
    }

    @Epic("HerokuApp")
    @Feature("JavaScript Confirm ")
    @Story("User JavaScript Confirm  button")
    @Test(description = "Verify JavaScript Confirm functionality")
    public void testConfirmAlert(){
        AlertsPage alertPage = new HomePage(getDriver()).clickAlertsLink();
        alertPage.triggerConfirmAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultMessage(), "You clicked: Ok", "Result message is incorrect");
    }

    @Epic("HerokuApp")
    @Feature("JavaScript Prompt ")
    @Story("User JavaScript Prompt  button")
    @Test(description = "Verify JavaScript Prompt functionality")
    public void testPromptAlert(){
        AlertsPage alertPage = new HomePage(getDriver()).clickAlertsLink();
        String prompt = "testPromptAlert";
        alertPage.triggerPromptAlert();
        alertPage.enterPrompt(prompt);
        assertEquals(alertPage.getResultMessage(), "You entered: "+prompt, "Prompt message is incorrect");
    }

}
