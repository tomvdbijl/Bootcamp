package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    @FindBy(css = "a[title='My wishlists']")
    private WebElement wishlistButton;

    @FindBy(className = "page-heading")
    private WebElement screenName;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickWishlist(){
        wishlistButton.click();
    }

    public String getScreenName(){
        return screenName.getText();
    }

}
