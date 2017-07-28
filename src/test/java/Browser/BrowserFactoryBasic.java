package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class BrowserFactoryBasic {

    public static WebDriver getDriver(String browser){
        WebDriver driver;

        switch(browser.toLowerCase()){
            case "firefox" :
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;

            case "ie" :
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;

            case "chrome" :
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;

            case "edge" :
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;

            default:
                driver = null;
        }
        return driver;
    }
}
