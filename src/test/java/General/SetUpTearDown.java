package General;

import Browser.BrowserFactoryAdvanced;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUpTearDown {

    // niemand anders mag de driver aanpassen. alleen hier starten en afsluiten
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        String browser = "firefox";
        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
//        driver = BrowserFactoryBasic.getDriver(browser);
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browsers.CHROME);
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
