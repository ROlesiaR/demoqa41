package tests;

import config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @BeforeClass
    public void beforClass(){
        ConfigManager.navigateToMainPage();
        mainPage.openElementsPage();
        elementsPage.openTextBoxPage();
    }
    @Test
    public  void textBoxPageOpened() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(textBoxPage.validateURLTextBoxCorrect());
    }
}
