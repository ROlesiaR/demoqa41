package pages;

public class TextBoxPage extends  BasePage{
    public boolean validateURLTextBoxCorrect() {
        String url = "https://demoqa.com/text-box";
        String currentUrl = getCurrentUrlBase();
        return isTextEqual2Strings(currentUrl,url);
    }
}
