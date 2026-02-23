package alerts;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTest {
    private AlertsPage alertPage;
@BeforeMethod
public void goToAlertPage(){
     alertPage = homePage.clickAlertsLink();
}
    @Test
    public void testAlert(){

        alertPage.triggerAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultMessage(), "You successfully clicked an alert", "Result message is incorrect");
    }

    @Test
    public void testConfirmAlert(){

        alertPage.triggerConfirmAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultMessage(), "You clicked: Ok", "Result message is incorrect");


    }

    @Test
    public void testPromptAlert(){
    String prompt = "testPromptAlert";
    alertPage.triggerPromptAlert();
   alertPage.enterPrompt(prompt);
    assertEquals(alertPage.getResultMessage(), "You entered: "+prompt, "Prompt message is incorrect");


    }

    @AfterMethod
    public void goBack(){
        driver.navigate().back();
    }
}
