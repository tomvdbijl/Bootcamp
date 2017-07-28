package chapterSix;

import General.SetUpTearDown;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CreateAccountTest extends SetUpTearDown{

    @Test
    public void createAccountSuccesFull() {
        String schermTitel = null;

        driver.findElement(By.className("login")).click();
        schermTitel = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(schermTitel)
                .as("Het scherm Authentication verschijnt niet!")
                .isEqualTo("AUTHENTICATION");

        Random rand = new Random();
        int randomNumber = rand.nextInt(1000 - 100 + 1) + 100;
        String emailadres = "tester" + randomNumber +"@test.com";
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys(emailadres);

        driver.findElement(By.id("SubmitCreate")).click();

        WebElement firstnameElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));

        schermTitel = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(schermTitel)
                .as("Het scherm CREATE AN ACCOUNT verschijnt niet!")
                .isEqualTo("CREATE AN ACCOUNT");

        String formTitel = driver.findElement(By.className("page-subheading")).getText();
        Assertions.assertThat(formTitel)
                .as("Het scherm CREATE AN ACCOUNT verschijnt niet!")
                .isEqualTo("YOUR PERSONAL INFORMATION");

        driver.findElement(By.id("id_gender1")).click();
        //customer_firstname
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("Michel");

        //customer_lastname
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("Bootcamp Butje");

        //email
        String formEmailadress = driver.findElement(By.id("email")).getAttribute("Value");
        // validate emailadres
        Assertions.assertThat(formEmailadress)
                .as("Het email adres komt niet overeen!")
                .isEqualTo(emailadres);
        //passwd
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        //submitAccount
        driver.findElement(By.id("submitAccount")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.logout")));

        String alertSucces = driver.findElement(By.cssSelector("p.alert.alert-success")).getText();

        // validate emailadres
        Assertions.assertThat(alertSucces)
                .as("Het email adres komt niet overeen!")
                .isEqualTo("Your account has been created.");

        driver.findElement(By.cssSelector("a.logout")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));

        schermTitel = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(schermTitel)
                .as("Het scherm Authentication verschijnt niet!")
                .isEqualTo("AUTHENTICATION");
    }
}
