package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "select#id_contact")
    private Select subjectHeadingSelect;

    @FindBy(css = "#email")
    private WebElement emailadressTextField;

    @FindBy(css = "p.form-group.form-error")
    private WebElement emailValidationCheck;

    @FindBy(id = "id_order")
    private WebElement orderReferenceTextField;

    @FindBy(id = "message")
    private WebElement messageTextField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;

    @FindBy(css = "p.alert.alert-success")
    private WebElement successMessageField;

    @FindBy(css = ".alert.alert-danger>ol>li")
    private WebElement errorMessageField;

    @FindBy(css = "div.form-group.form-error")
    private WebElement elementErrorCheck;

    @FindBy (css = "page-heading bottom-indent")
    private WebElement screenName;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;

        // This call sets the WebElement
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String email, String orderReference, String subjectHeading, String message){
        Select subjectHeading2 = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading2.selectByVisibleText(subjectHeading);

        // Fill fields
//        subjectHeadingSelect.selectByVisibleText(subjectHeading);
        emailadressTextField.sendKeys(email);
        orderReferenceTextField.sendKeys(orderReference);
        messageTextField.sendKeys(message);
        // Click submit button
        submitButton.click();
    }

    public String checkSuccessMessage(){
        return successMessageField.getText();
    }

    public boolean checkScreenNameFound(String screenName){
        return screenName.contains(screenName);
    }

    public boolean checkErrorMessage(String errorMessage){
        return errorMessageField.getText().equals(errorMessage);
    }

    public boolean emailValidationCheck(){
        return emailValidationCheck.isDisplayed();
    }

    public void fillSubjectHeading(String subjectHeading){
        Select subjectHeading2 = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading2.selectByVisibleText(subjectHeading);
    }

    public void fillEmailAdress(String email){
        emailadressTextField.sendKeys(email);
    }

    public void fillOrderReference(String orderReference){
        orderReferenceTextField.sendKeys(orderReference);
    }

    public void fillMessage(String message){
        messageTextField.sendKeys(message);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}

