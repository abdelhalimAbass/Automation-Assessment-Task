package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class FacebookTest extends BaseTest {

    @Test
    public void testFacebookFlow() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ConfigReader config = new ConfigReader();
        //  Login
        // CAPTCHA may appear here - cannot be automated
        loginPage.login(config.getUsername(), config.getPassword());
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("facebook.com"));
        // Assert "No more posts"
        Assertions.assertTrue(homePage.isNoMorePostsVisible());
        homePage.logout();
        Assertions.assertTrue(driver.getTitle().contains("Facebook"));
    }
}
