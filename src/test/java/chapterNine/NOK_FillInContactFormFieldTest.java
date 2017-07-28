package chapterNine;

import General.SetUpTearDown;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_FillInContactFormFieldTest extends SetUpTearDown {

    @Test
    public void NOK_FillInContactEmailFieldForm() {

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
        if(contactUs.emailValidationCheck()){
            contactUs.fillEmailAdress("nope@correct.com");
            Assertions.assertThat(contactUs.emailValidationCheck())
                    .as("The email address is invalid")
                    .isTrue();
        }
        contactUs.fillMessage("HELP!!!");
        contactUs.clickSubmit();

        Assertions.assertThat(contactUs.checkSuccessMessage())
                .as("The contact form isn't send!")
                .isEqualTo("Your message has been successfully sent to our team.");
    }
}
