import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/mnats/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com");
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.typeUsername("reporttest");
        loginPage.typePassword("qwerty");
        loginPage.clickSignInButton();
        assertTrue(loginPage.isLoggedIn(), "User logged in successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
