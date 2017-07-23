package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "passwd")
    private WebElement passwdTextField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    public LogInPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String email){
        emailTextField.sendKeys(email);
    }

    public void fillPassword(String password){
        passwdTextField.sendKeys(password);
    }

    public void clickSubmit(){
        submitLoginButton.click();
    }

}
