package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class FacebookTest extends BaseTest {

    @Test
    public void testFacebookFlow() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //  Login
        loginPage.login("deboabas1@gmail.com", "Abas@2019");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("facebook.com"));
        //CAPTCHA verification is not handled as it is a security feature and not intended to be automated
        // Assert "No more posts"
        Assertions.assertTrue(homePage.isNoMorePostsVisible());
        homePage.logout();
        Assertions.assertTrue(driver.getTitle().contains("Facebook"));
    }
}
