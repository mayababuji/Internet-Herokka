package alerts;

import base.BaseTest;
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
    @Test
    public void testAlert(){
        AlertsPage alertPage = new HomePage(getDriver()).clickAlertsLink();
        alertPage.triggerAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultMessage(), "You successfully clicked an alert", "Result message is incorrect");
    }

    @Test
    public void testConfirmAlert(){
        AlertsPage alertPage = new HomePage(getDriver()).clickAlertsLink();
        alertPage.triggerConfirmAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultMessage(), "You clicked: Ok", "Result message is incorrect");
    }

    @Test
    public void testPromptAlert(){
        AlertsPage alertPage = new HomePage(getDriver()).clickAlertsLink();
        String prompt = "testPromptAlert";
        alertPage.triggerPromptAlert();
        alertPage.enterPrompt(prompt);
        assertEquals(alertPage.getResultMessage(), "You entered: "+prompt, "Prompt message is incorrect");
    }

}
