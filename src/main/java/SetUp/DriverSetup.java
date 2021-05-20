package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
    public static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/Users/mnats/Documents/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
