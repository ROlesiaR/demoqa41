package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ConfigManager {
    private static WebDriver driver ;
    public static WebDriverManager getDriver(){
        if (driver==null){
            setUp();
        }
        return driver;
    }
    @BeforeSuite
    @Parameters("browser" )
    private static void setUp(@Optional("chrome")String browser) {
if (browser.equalsIgnoreCase("chrome")){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--lang=en");
    //chromeOptions.addArguments("--headless");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(chromeOptions);
}
else if (browser.equalsIgnoreCase("firefox")){
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.addPreference("intel.accept_laguages","en");
    //firefoxOptions.addArguments("--headless");
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver(firefoxOptions);
}
else if (browser.equalsIgnoreCase("edge")){
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.setCapability("language","en");
    //edgeOptions.addArguments("--headless");
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver(edgeOptions);
}
    else {
        throw new IllegalArgumentException("Invalid browser name:"+browser)
    }
    }
    @AfterSuite
    public static void tearDown(){
        driver.quit();
    }
}
