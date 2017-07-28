package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactoryAdvanced {

    public enum Browsers {
        CHROME,
        FIREFOX,
        IE,
        EDGE;
    }

    public static WebDriver getDriver(Browsers browser) {

        switch (browser) {
            case FIREFOX:
                return setFireFoxDriver();

            case IE:
                return setInternetExplorerDriver();

            case CHROME:
                return setChromeDriver();

            default:
                return setChromeDriver();
        }
    }

    private static WebDriver setFireFoxDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(capabilities);
    }

    private static WebDriver setInternetExplorerDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver(capabilities);
    }

    private static WebDriver setChromeDriver(){
        // setten van proxy in chrome
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("ignore-certificcate-errors");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        // Proxy proxy = new Proxy();
        // proxy.setHttpProxy("myHTTPProxy:PortNumber");
        // capabilities.setCapabilities("proxy", proxy);

        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities);
    }
}
