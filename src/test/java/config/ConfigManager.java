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

import java.time.Duration;

public class ConfigManager {
    private static WebDriver driver ;
    public static WebDriver getDriver(){
//        int counter = 0;
//        while (driver==null|| counter<=5) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

            //        if (driver==null){
//            setUp(@Optional("chrome")browser);
//        }
        return driver;
    }
    @BeforeSuite
    @Parameters("browser")
    public static void setUp(@Optional("chrome")String browser) {
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
        throw new IllegalArgumentException("Invalid browser name:"+browser);
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
    //driver.navigate().to("http://demoqa.com/");
       navigateToMainPage();
    }
    public static void navigateToMainPage(){
        driver.navigate().to("http://demoqa.com/");
    }
    @AfterSuite
    private static void tearDown(){
        driver.quit();
    }
}
