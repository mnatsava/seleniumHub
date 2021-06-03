import com.google.common.base.Enums;
import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static setup.DriverSetup.getDriver;

public class TestBase {
    public String key;

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterMethod
    public void removeUser() throws IOException {
        ApiHelper.removeUser(key);
    }

    @BeforeMethod
    public void login() throws IOException {
        JsonObject user = ApiHelper.createUser();
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));

        getDriver().navigate().refresh();
    }
}
