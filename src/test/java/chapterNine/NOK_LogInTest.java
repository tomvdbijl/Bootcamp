package chapterNine;

import General.SetUpTearDown;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class NOK_LogInTest extends SetUpTearDown {

    // test lege velden
    @Test
    public void NOK_LogInEmptyFields(){
        HomePage homePage = new HomePage(driver);
        if (!homePage.signInDisplayed()) {
            homePage.clickLogout();
        }

        homePage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail("");
        logInPage.fillPassword("");
        logInPage.clickSubmit();

        String errorMessage = "An email address required.";
        Assertions.assertThat(logInPage.checkErrorMessage(errorMessage))
                .as("Error message '"+ errorMessage + "' isn't displayed!")
                .isTrue();
    }

    // test geen username
    @Test
    public void NOK_LogInEmptyEmailAddress(){
        HomePage homePage = new HomePage(driver);
        if (!homePage.signInDisplayed()) {
            homePage.clickLogout();
        }

        homePage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail("");
        logInPage.fillPassword("1qazxsw2");

        Assertions.assertThat(logInPage.emailValidationCheck())
                .as("Email address is valid!")
                .isTrue();

        logInPage.clickSubmit();

        String errorMessage = "An email address required.";
        Assertions.assertThat(logInPage.checkErrorMessage(errorMessage))
                .as("Error message '"+ errorMessage + "' isn't displayed!")
                .isTrue();
    }

    // test geen password
    @Test
    public void NOK_LogInEmptyPassword(){
        HomePage homePage = new HomePage(driver);
        if (!homePage.signInDisplayed()) {
            homePage.clickLogout();
        }

        homePage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail("tom@vanderbijl.com");
        logInPage.fillPassword("");
        logInPage.clickSubmit();

        String errorMessage = "Password is required.";
        Assertions.assertThat(logInPage.checkErrorMessage(errorMessage))
                .as("Error message '"+ errorMessage + "' isn't displayed!")
                .isTrue();
    }

    // test verkeerd username
    @Test
    public void NOK_LogInWrongEmailAddress(){
        HomePage homePage = new HomePage(driver);
        if (!homePage.signInDisplayed()) {
            homePage.clickLogout();
        }

        homePage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail("xx@xx.xx");
        logInPage.fillPassword("1qazxsw2");
        logInPage.clickSubmit();

        String errorMessage = "Authentication failed.";
        Assertions.assertThat(logInPage.checkErrorMessage(errorMessage))
                .as("Error message '"+ errorMessage + "' isn't displayed!")
                .isTrue();
    }

    // test verkeerd password
    @Test
    public void NOK_LogInWrongPassword(){
        HomePage homePage = new HomePage(driver);
        if (!homePage.signInDisplayed()) {
            homePage.clickLogout();
        }

        homePage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail("tom@vanderbijl.com");
        logInPage.fillPassword("2wsxzaq1");
        logInPage.clickSubmit();

        String errorMessage = "Authentication failed.";
        Assertions.assertThat(logInPage.checkErrorMessage(errorMessage))
                .as("Error message '"+ errorMessage + "' isn't displayed!")
                .isTrue();
    }


}
