import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public class base {

    public AndroidDriver driver;

    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("R9KYC02Q6EE");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\Masarat\\Desktop\\task\\Automation_Assessment\\test_demo.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}