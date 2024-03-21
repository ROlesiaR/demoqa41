package tests;

import config.ConfigManager;
import dto.TextBoxUserInfo;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ScreenShortManager;

public class TextBoxTest extends BaseTest {

    @BeforeClass
    public void beforClass(){
        ConfigManager.navigateToMainPage();
        mainPage.openElementsPage();
        elementsPage.openTextBoxPage();
    }
    @Test
    public  void textBoxPageOpened() throws InterruptedException {
        //Thread.sleep(5000);
        Assert.assertTrue(textBoxPage.validateURLTextBoxCorrect());
    }
    @Test(description = "tst with filling form with validate the common result")
    public void testForm() {
        Allure.description("test with filling all fields in the form and validate the common result");
        Allure.step("creat and fill object TextBoxUserInfo");
        TextBoxUserInfo textBoxUserInfo = new TextBoxUserInfo()
                .withName("John")
                .withMail("john@mail.com")
                .withCurrentAddress("first street")
                .withPermanentAddress("second street");
        Allure.step("fill form and send data to inputs and click on the submit button");
        textBoxPage.fillForm(textBoxUserInfo);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Allure.step("take screen shots");
        ScreenShortManager.takeScreenshot("testForm");
        Assert.assertTrue(textBoxPage.validateUserInfoDisplaysCorrect(textBoxUserInfo));
    }
}
