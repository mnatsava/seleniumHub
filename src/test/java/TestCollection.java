import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCollection extends TestBase {

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
    public void qrTest() {
        ChallengePage challengePage = new ChallengePage("srcjunecalendar2021");
        GetFreeAppDialog getFreeAppDialog = challengePage.clickParticipate();
        assertTrue(getFreeAppDialog.isQrVisible(), "QR was not displayed!");
    }

    @Test
    public void verifyItemsCountInSideBar() {
        CreatePage createPage = new CreatePage();
        EditorPage editorPage = createPage.clickInstagramStory();
        createPage.changeTab(1);
        editorPage.clickOnFitIcon();
        assertEquals(editorPage.getCountOfItemsInSideBar(), 28, "Items count isn't 28 in Side Bar");
    }

    @Test //Create test
    public void upload() {
        CreatePage createPage = new CreatePage();
        createPage.open();
        createPage.uploadPhoto();
    }

    @Test
    public void verifyLikeFunctionality() throws IOException {
        JsonObject image = ApiHelper.uploadPhoto(key);
        ApiHelper.likePhoto(key, image.get("id").getAsString());
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(image.get("id").getAsString());
    }

    @Test
    public void uploadPhotoWithHashtag() throws IOException, InterruptedException {
        String hashtagName = "testing";
        String imageId = ApiHelper.uploadPhoto(key).getAsJsonObject().get("id").getAsString();
        ApiHelper.addHashtag(key, imageId, hashtagName);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(imageId);
        assertTrue(imageBrowserPage.isHashtagByNameVisible(hashtagName), "Hashtag " + hashtagName + " isn't visible");
    }

    @Test
    public void clickInstagramStory(){
        EditorPage editorPage = new EditorPage();
        editorPage.clickInstagramStory();
        editorPage.changeTab(1);
        editorPage.clickFitIcon();
        assertEquals(editorPage.getItemsCount(), 28, "Items count in editor was not correct!");
    }
}
