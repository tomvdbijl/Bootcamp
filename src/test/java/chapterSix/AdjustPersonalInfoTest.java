package chapterSix;

import General.SetUpTearDown;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AdjustPersonalInfoTest extends SetUpTearDown{

    @Test
    public void wijzigPersoonsGegevens(){
        String schermTitel= null;

        // controleren of er iemand is ingelogd
        boolean isIngelogd = driver.findElement(By.className("login")).isDisplayed();
        if(isIngelogd){
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
        }

        driver.findElement(By.cssSelector("a[title='Information']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-subheading")));
        Assertions.assertThat(driver.findElement(By.cssSelector("h1.page-subheading")).getText())
                .as("Het scherm  Your personal information verschijnt niet!")
                .isEqualTo("YOUR PERSONAL INFORMATION");
    }
}
