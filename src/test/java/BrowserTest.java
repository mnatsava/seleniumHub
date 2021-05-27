import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;


public class BrowserTest extends TestBase {
    private String key;

    @BeforeMethod
    public void setup() throws IOException {
        JsonObject user = ApiHelper.createUser();
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

    }

    @AfterMethod
    public void removeUser() throws IOException {
        ApiHelper.removeUser(key);
    }

    @Test
    public void like() throws IOException {
        JsonObject image = ApiHelper.uploadPhoto(key);
        ApiHelper.likePhoto(key, image.get("id").getAsString());
        new ImageBrowserPage(image.get("id").getAsString());
    }

    @Test
    public void uploadPhotoWithHashtag() throws IOException, InterruptedException {
        String hashtagName = "testing";
        String imageId = ApiHelper.uploadPhoto(key).getAsJsonObject().get("id").getAsString();
        ApiHelper.addHashtag(key, imageId, hashtagName);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(imageId);

        assertTrue(imageBrowserPage.isHashtagByNameVisible(hashtagName), "Hashtag " + hashtagName +  " isn't visible");
    }
}
