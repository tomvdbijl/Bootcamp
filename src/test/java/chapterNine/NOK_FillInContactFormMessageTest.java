package chapterNine;

import General.SetUpTearDown;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_FillInContactFormMessageTest extends SetUpTearDown{

    @Test
    public void NOK_FillInContactMessageForm() {
       HomePage homePage = new HomePage(driver);
        if (!homePage.signInDisplayed()) {
            homePage.clickLogout();
        }
        homePage.clickContactUs();

        ContactUsPage contactUs = new ContactUsPage(driver);
        Assertions.assertThat(contactUs.checkScreenNameFound("CUSTOMER SERVICE"))
                .as("'Customer service' screen isn't displayed!")
                .isTrue();

        contactUs.fillSubjectHeading("Customer service");
        contactUs.fillEmailAdress("nope");
        contactUs.fillOrderReference("4321234");
        contactUs.fillMessage("HELP!!!");
        contactUs.clickSubmit();

        Assertions.assertThat(contactUs.checkErrorMessage("Invalid email address."))
                .as("The error mesage 'Invalid email address.' isn't displayed!")
                .isTrue();
    }
}
