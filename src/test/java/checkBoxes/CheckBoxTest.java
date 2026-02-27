package checkBoxes;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.HomePage;

public class CheckBoxTest extends BaseTest {
    @BeforeMethod
    public void goToCheckBoxPage() {
        getDriver().get("https://the-internet.herokuapp.com");
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
    @Feature("CheckBoxes ")
    @Epic("User CLicks on CheckBoxes  link")
    @Test(description = "Verify if first check box is clicked")
    public void firstCheckBoxTest(){
        CheckBoxPage checkBoxPage = new HomePage(getDriver()).clickCheckBoxLink();
        checkBoxPage.clickOnFirstCheckBox();
        boolean isSelected = checkBoxPage.validateClickOnFirstCheckBox();
        Assert.assertTrue(isSelected);

    }

    @Test(description = "Verify if second check box is unchecked")
    public void secondCheckBoxTest(){
        CheckBoxPage checkBoxPage = new HomePage(getDriver()).clickCheckBoxLink();
        checkBoxPage.clickOnSecondCheckBox();
        boolean isNotChecked = checkBoxPage.validateSecondCheckBox();
        Assert.assertTrue(isNotChecked);
    }



}
