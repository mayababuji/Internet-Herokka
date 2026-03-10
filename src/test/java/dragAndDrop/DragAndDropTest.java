package dragAndDrop;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.HomePage;

@Epic("HerokuApp")
public class DragAndDropTest extends BaseTest {

    @Test
    public void clickDragAndDropLink()  {
        DragAndDropPage dragAndDropPage = new HomePage(getDriver()).clickDragAndDropLink();
        String coulmnBTextBeforeDragAndDrop = dragAndDropPage.getColumnBText();
        System.out.println(coulmnBTextBeforeDragAndDrop);
        dragAndDropPage.dragAndDrop();
        String coulmnAText = dragAndDropPage.getColumnAText();
        System.out.println(coulmnAText);
        Assert.assertEquals(coulmnBTextBeforeDragAndDrop, coulmnAText);




    }

}


