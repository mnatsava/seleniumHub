import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;

import static setup.DriverSetup.getDriver;

/**
 * @author Sargis Sargsyan on 5/20/21
 * @project picsart-internal-training
 */
public class TestBase {

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    public void login() {
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", "301e0f0c-8e57-43c1-a9f8-6f2388cd3d4d");
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));

        getDriver().navigate().refresh();
    }
}
