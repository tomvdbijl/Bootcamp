package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(css = "li#header_link_contact > a")
    private WebElement contactUsLink;

    @FindBy(className = "logout")
    private WebElement signOutLink;

    public HomePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickContactUs(){
        contactUsLink.click();
    }

    public void clickSignIn(){
        signInLink.click();
    }

    public void clickLogout(){
        signOutLink.click();
    }

    public boolean signOutDisplayed(){
        return signOutLink.isDisplayed();
    }

    public boolean signInDisplayed(){
        return  signInLink.isDisplayed();
    }
}
