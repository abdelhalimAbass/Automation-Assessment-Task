import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class E2ETest extends base {

    @Test
    public void fullFlowTest() throws Exception {

        setup();

        // Step 1: URL
        WebElement input = driver.findElement(By.xpath("//android.widget.EditText"));
        input.click();
        input.sendKeys("http://155.0.0.1");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Connect\"]")).click();
        // Step 2: Home screen
        assertTrue(driver.findElement(By.xpath("//android.view.View[@content-desc=\"Loaded Content\"]")).isDisplayed());
        // Step 3: Item 5
        driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"View Details\"])[5]")).click();

        // Step 4: Delete
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Back\"]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Item 5\"]/android.widget.Button[2]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Delete\"]")).click();

        // Step 5: Success
        assertTrue(driver.findElement(By.xpath("//android.view.View[@content-desc=\"Item 5 deleted successfully\"]")).isDisplayed());

        driver.quit();
    }
}