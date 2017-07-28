package homework;

import General.SetUpTearDown;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.WishlistPage;

public class DeleteWishListTest extends SetUpTearDown{

    @Test
    public void deleteWishList(){
        HomePage homePage = new HomePage(driver);
        if(!homePage.signInDisplayed()){
            homePage.clickLogout();
        }
        homePage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillEmail("tom@vanderbijl.com");
        logInPage.fillPassword("1qazxsw2");
        logInPage.clickSubmit();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assertions.assertThat(myAccountPage.getScreenName())
                .as("My Account screen is not displayed!")
                .isEqualTo("MY ACCOUNT");
        myAccountPage.clickWishlist();

        String wishListItem = "Feel the pain";

        WishlistPage wishlistPage = new WishlistPage(driver);
        Assertions.assertThat(wishlistPage.getScreenName())
                .as("My wishlists screen is not displayed!")
                .isEqualTo("MY WISHLISTS");
        wishlistPage.deleteWishFromList(wishListItem);

        boolean itemFound = wishlistPage.foundTextInTable(wishListItem);

        Assertions.assertThat(itemFound)
                .as("'" + wishListItem + "' hoort niet voor te komen in de wishlist!")
                .isFalse();

        rollBack(wishListItem);

    }

    private void rollBack(String item){
        WishlistPage wishlistPage = new WishlistPage(driver);
        wishlistPage.fillWishName(item);
        wishlistPage.clickSave();

        wishlistPage.refresPage();

        Assertions.assertThat(wishlistPage.foundTextInTable(item))
                .as("'" + item + "' komt niet voor in de wishlist!")
                .isTrue();
    }
}
