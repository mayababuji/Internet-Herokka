package basicAuth;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasicAuthPage;

import static org.testng.Assert.assertEquals;
@Epic("HerokuApp")
public class BasicAuthTest extends BaseTest {
    @BeforeMethod
    public void goToBasicAuthPage() {
        getDriver().get("https://the-internet.herokuapp.com");
        System.out.println("Running thread: " + Thread.currentThread().getName());

    }

    @Feature("Basic Auth")
    @Story("User logins with basic auth")
    @Test(description = "Verify  if the login is successful")
    public void basicAuthTest(){
     getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
     String message = basicAuthPage.getSuccessMessage();
     System.out.println(message);
        assertEquals(message,  "Congratulations! You must have the proper credentials.","Success message is incorrect");


    }
    @Story("User logins with invalid credentials for basic auth")
    @Test(description = "Verify success message is not returned for invalid credentials")
    public void basicAuthUnauthorizedTest() {
        getDriver().get("https://wrong:wrong@the-internet.herokuapp.com/basic_auth");

        String pageSource = getDriver().getPageSource();

        boolean successMessagePresent = pageSource.contains("Congratulations!");

        assertEquals(successMessagePresent, false, "User should NOT be authenticated with invalid credentials");
    }

}
