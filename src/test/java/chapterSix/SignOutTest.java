package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignOutTest {

    @Test
    public void logOutSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        String schermTitel = null;

        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

        driver.findElement(By.className("login")).click();
        schermTitel = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(schermTitel)
                .as("Het scherm Authentication verschijnt niet!")
                .isEqualTo("AUTHENTICATION");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        driver.findElement(By.id("SubmitLogin")).click();
        schermTitel = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(schermTitel)
                .as("Het scherm My account verschijnt niet!")
                .isEqualTo("MY ACCOUNT");

        driver.findElement(By.className("logout")).click();
        schermTitel = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(schermTitel)
                .as("Het scherm Authentication verschijnt niet!")
                .isEqualTo("AUTHENTICATION");


        driver.quit();
    }
}
