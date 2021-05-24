import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class BrowserTest extends TestBase {

    @Test
    public void verifyLikeDislikeFunctionality() {
        login();
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage("359023365022201");

        if (imageBrowserPage.isImageLiked()) {
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isImageLiked(), "Image isn't unliked");
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isImageLiked(), "Image isn't liked");
        } else {
            imageBrowserPage.clickOnLikeIcon();
            assertTrue(imageBrowserPage.isImageLiked(), "Image isn't liked");
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isImageLiked(), "Image isn't unliked");
        }
    }


}
