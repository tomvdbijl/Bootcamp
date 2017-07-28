package chapterNine;

import General.SetUpTearDown;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class FillInContactFormTest extends SetUpTearDown{

    @Test
    public void fillInContactForm(){
        HomePage homePage = new HomePage(driver);
        homePage.clickContactUs();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
//        contactUsPage.fillInContactForm("bootcamper@feelthepain.com",
//                "4321234",
//                "Customer service",
//                "Ipod defect while lifting, demand new one!!!");
        contactUsPage.fillSubjectHeading("Customer service");
        contactUsPage.fillOrderReference("4321234");
        contactUsPage.fillEmailAdress("bootcamper@feelthepain.com");
        contactUsPage.fillMessage("Ipod defect while lifting, demand new one!!!");
        contactUsPage.clickSubmit();

        Assertions.assertThat(contactUsPage.checkSuccessMessage())
                .as("The form is not send successfully!")
                .isEqualTo("Your message has been successfully sent to our team.");
    }

}
