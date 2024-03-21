package pages;

import dto.TextBoxUserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBoxPage extends  BasePage{
    By inputUserName = By.xpath("//input[@id='userName']");
    By inputUserEmail = By.xpath("//input[@id='userEmail']");
    By placeHolderAddress = By.xpath("//textarea[@id='currentAddress']");
    By placeHolderAddressPermanent = By.xpath("//textarea[@id='permanentAddress']");
    By btnSubmit = By.xpath("//button[@id='submit']");
    By resultsTextBox = By.xpath("//div[@id='output']//p");

    public void fillForm(TextBoxUserInfo textBoxUserInfo){
        sendTextBase(inputUserName,textBoxUserInfo.getName());
        sendTextBase(inputUserEmail,textBoxUserInfo.getMail());
        sendTextBase(placeHolderAddress,textBoxUserInfo.getCurrentAddress());
        sendTextBase(placeHolderAddressPermanent,textBoxUserInfo.getPermanentAddress());
        clickBase(btnSubmit);
    }


    public boolean validateURLTextBoxCorrect() {
        String url = "https://demoqa.com/text-box";
        String currentUrl = getCurrentUrlBase();
        return isTextEqual2Strings(currentUrl,url);
    }

    public boolean validateUserInfoDisplaysCorrect(TextBoxUserInfo textBoxUserInfo) {
        List<WebElement> elements = findElementsBase(resultsTextBox);
        int counter = 0;
        String result ="";
        for (WebElement e: elements){
            result = result+getTextBaseElement(e);
        }
        System.out.println(result);
        if (result.contains(textBoxUserInfo.getName())
                &&result.contains(textBoxUserInfo.getMail())
                &&result.contains(textBoxUserInfo.getCurrentAddress())
                &&result.contains(textBoxUserInfo.getPermanentAddress())) {
            return true;
        }else {
            return false;
        }
    }
}
