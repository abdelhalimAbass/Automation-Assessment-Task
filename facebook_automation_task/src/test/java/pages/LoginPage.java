package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By email = By.cssSelector("input[name=\"email\"]");
    By password = By.cssSelector("input[name=\"pass\"]");
    By loginBtn = By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[3]/div/div/div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String passWord) {
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(passWord);
        driver.findElement(loginBtn).click();
    }
}