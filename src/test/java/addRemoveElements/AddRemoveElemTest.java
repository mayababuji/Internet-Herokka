package addRemoveElements;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddRemoveElemPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;


public class AddRemoveElemTest extends BaseTest {
    @BeforeMethod
    public void goToAddRemoveElemPage(){
        getDriver().get("https://the-internet.herokuapp.com");
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
    @Epic("HerokuApp")
    @Feature("Add/Remove Elements")
    @Story("User clicks add remove elements button")
    @Test(description = "Verify  add remove elements button functionality")
    public void addRemoveElementTest(){
      AddRemoveElemPage addRemoveElemPage = new HomePage(getDriver()).clickAddRemoveLink();
      addRemoveElemPage.clickAddRemoveElement();
      addRemoveElemPage.clickAddRemoveElement();
      int size = addRemoveElemPage.getDeleteButtonCount();
      System.out.println("The number of delete buttons are "+ size);

    assertEquals(size,2,"Delete button count is incorrect expected was "+'2'+" actual was "+size);
  }

    @Epic("HerokuApp")
    @Feature("Add/Remove Elements")
    @Story("User clicks delete elements button")
    @Test(description = "Verify delete button functionality")
    public void removeElementTest(){
      AddRemoveElemPage addRemoveElemPage = new HomePage(getDriver()).clickAddRemoveLink();
      addRemoveElemPage.clickAddRemoveElement();
      addRemoveElemPage.clickAddRemoveElement();
      addRemoveElemPage.clickOnDeleteButton();
      int size = addRemoveElemPage.getDeleteButtonCount();
      System.out.println("The number of delete buttons are "+ size);
      assertEquals(size,0,"Delete button count is incorrect expected was "+'0'+" actual was "+size);

  }

}
