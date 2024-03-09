package pages;

import config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage {


    protected WebElement findElementBase (By locator){
        return ConfigManager.getDriver().findElement(locator);
    }
    protected String getTextBase(By locator){
        return findElementBase(locator).getText().toUpperCase().toUpperCase().trim();
    }
    protected  void clickBase (By locator){
        findElementBase(locator).click();
    }
    protected void jsExecutorBase(String str){
        JavascriptExecutor js = (JavascriptExecutor) ConfigManager.getDriver();
        js.executeScript(str);
    }
    protected boolean isTextEqual(By locator, String expectedResult){
        expectedResult = expectedResult.toUpperCase().trim();
        String actualResult = getTextBase(locator);
   return isTextEqual2Strings(actualResult,expectedResult);

    }
    protected String getCurrentUrlBase(){
        return ConfigManager.getDriver().getCurrentUrl();
    }
    protected boolean isTextEqual2Strings(String actualResult, String expectedResult){
        if (expectedResult.equals(actualResult)){
            return true;
        }
        else{
            System.out.println("actual res: "+ actualResult+ " expected res: "+ expectedResult);
            return false;
        }
    }


}
