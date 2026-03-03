package digestAuthentication;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
Digest Authentication triggers a browser‑level authentication dialog,
which is not part of the DOM and cannot be interacted with using
Selenium locators. Modern browsers also block URL‑embedded credentials for
security reasons, and Selenium’s DevTools authentication APIs vary
across versions and are not consistently reliable. Because Digest Auth is a network‑layer protocol,
validating it through an HTTP client (RestAssured) is the correct, stable, and industry‑standard approach
 */

public class DigestAuthenticationTest extends BaseTest {

    @Epic("Authentication Mechanisms Validation")
    @Feature("Digest Authentication Handling")
    @Test(description = "Ensures Digest Authentication succeeds and returns expected success message")
    public void digestAuthenticationClicked()
    {
        Response response = RestAssured
                .given() .auth().digest("admin", "admin")
                .when()
                .get("https://the-internet.herokuapp.com/digest_auth");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.asString().contains("Congratulations"));


    }
}

