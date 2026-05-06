package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By profileMenu = By.xpath("//span[text()='Account']");
    By logoutBtn = By.xpath("//span[contains(text()='Log Out')]");
    // ️ دي مش stable قوي
    By noMorePosts = By.xpath("//*[contains(text(),'No more posts')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isNoMorePostsVisible() {
        return driver.findElement(noMorePosts).isDisplayed();
    }
    public void logout() {
        driver.findElement(profileMenu).click();
        driver.findElement(logoutBtn).click();
    }
}
