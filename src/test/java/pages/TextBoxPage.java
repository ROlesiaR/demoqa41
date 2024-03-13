package pages;

import org.openqa.selenium.By;

public class TextBoxPage extends  BasePage{
    By inputUserName = By.xpath("//input[@id='userName']");
    By inputUserEmail = By.xpath("//input[@id='userEmail']");
    By placeHolderAddress = By.xpath("//textarea[@id='currentAddress']");
    By placeHolderAddressPermanent = By.xpath("//textarea[@id='permanentAddress']");
    By btnSubmit = By.xpath("//button[@id='submit']");
    By resultsTextBox = By.xpath("//div[@id='output']//p");

    public boolean validateURLTextBoxCorrect() {
        String url = "https://demoqa.com/text-box";
        String currentUrl = getCurrentUrlBase();
        return isTextEqual2Strings(currentUrl,url);
    }
}
