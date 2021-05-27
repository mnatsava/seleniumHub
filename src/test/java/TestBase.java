import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

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

    public void login() throws IOException {
        JsonObject user = ApiHelper.createUser();
        String key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));

        getDriver().navigate().refresh();
    }
}
