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

    @FindBy(css = "p.alert.alert-success")
    private WebElement successMessageField;

    @FindBy(css = ".alert.alert-danger>ol>li")
    private WebElement errorMessageField;

    @FindBy(css = "input#email.is_required.validate.account_input.form-control")
    private WebElement emailValidationCheck;

    @FindBy(css = "input#password.is_required.validate.account_input.form-control")
    private WebElement passwordValidationCheck;

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

    public String checkSuccessMessage(){
        return successMessageField.getText();
    }

    public boolean checkErrorMessage(String errorMessage){
        return errorMessageField.getText().equals(errorMessage);
    }

    public boolean emailValidationCheck(){
        return emailValidationCheck.isDisplayed();
    }

    public boolean passwordValidationCheck(){
        return passwordValidationCheck.isDisplayed();
    }

}
