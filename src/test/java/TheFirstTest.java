import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static setup.DriverSetup.getDriver;

/**
 * @author Sargis Sargsyan on 5/7/21
 * @project picsart-internal-training
 * username: tumo.test123@gmail.com
 * Password: Tumo2020!
 */
public class TheFirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "/Users/ss/dev/chromedriver");
//        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void fistTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();
        loginPage.typeUsername("tumo.test123@gmail.com");
        loginPage.typePassword("Tumo2020!");
        loginPage.clickSignInButton();

        assertTrue(loginPage.isUserLoggedIn(), "User eas not logged in!");
    }

    @Test
    public void loginWithKey() {
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", "d02e1fab-8630-4f25-a106-9969ab867447");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User eas not logged in!");
    }

    @Test
    public void clickInstagramStory(){
        login();
        EditorPage editorPage = new EditorPage();
        editorPage.clickInstagramStory();
        editorPage.changeTab(1);
        editorPage.clickFitIcon();
        assertEquals(editorPage.getItemsCount(), 28, "Items count in editor was not correct!");

    }

    private void login() {
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", "301e0f0c-8e57-43c1-a9f8-6f2388cd3d4d");
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));

        getDriver().navigate().refresh();
    }

}
