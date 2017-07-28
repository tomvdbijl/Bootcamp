package chapterSix;

import General.SetUpTearDown;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FillCartTest extends SetUpTearDown {

    @Test
    public void vullenWinkelwagenTest(){
        String schermTitel = null;

        // controleer dat de winkelwagen zichtbaar is
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed())
                .as("Cart is not displayed!")
                .isTrue();

        // controleer dat de winkelwagen leeg is
        String cardInhoud = driver.findElement(By.className("ajax_cart_no_product")).getText();
        Assertions.assertThat(cardInhoud)
                .as("Card inhoud is niet leeg!")
                .isEqualTo("(empty)");

        // klik op ipod onder tags
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();

        // controleer dat er ipods gevonden zijn
        String ipodElement = driver.findElement(By.cssSelector("h1.page-heading.product-listing")).getText();
        Assertions.assertThat(ipodElement)
                .as("Er zijn geen IPOD's gevonden!")
                .isEqualTo("SEARCH  \"IPOD\"\n3 results have been found.");

        // selecteer de ipod shuffle
        driver.findElement(By.cssSelector("a[title='iPod shuffle']")).click();

        // voeg de ipod toe aan de winkelwagen
        driver.findElement(By.id("add_to_cart")).click();

        // wacht op het winkelwagen schermpje
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='Continue shopping']")));

        // klik op continue shopping
        driver.findElement(By.xpath("//span[contains(@title, 'Continue shopping')]")).click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[title='Continue shopping']")));

        // controleer dat de ipod in de winkelwagen is toegevoegd
        String cardAmount = driver.findElement(By.cssSelector("span.ajax_cart_quantity")).getText();
        Assertions.assertThat(cardAmount)
                .as("Er is geen ipod aan de winkelwagen toegevoegd!")
                .isEqualTo("1");
    }
}
