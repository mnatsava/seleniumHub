import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static SetUp.DriverSetup.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest {
    private WebDriver driver;

    @Test
    public void loginWithKey() {
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", "d02e1fab-8630-4f25-a106-9969ab867447");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User eas not logged in!");
    }

    private void login() {
        new LoginPage();
        Cookie cookie = new Cookie("user_key", "301e0f0c-8e57-43c1-a9f8-6f2388cd3d4d");
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));

        getDriver().navigate().refresh();
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

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
