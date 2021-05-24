import org.openqa.selenium.By;

public class ImageBrowserPage extends BasePage {

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");

    public ImageBrowserPage () {
    }

    public ImageBrowserPage (String imageID) {
         open(BASE_URL + "/i/" + imageID);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickOnLikeIcon() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WaitHelper.getInstance().waitForElementToBeDisplayed(likeIconLocation);
        click(likeIconLocation);
    }

    public boolean isImageLiked() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return find(likeIconLocation).getAttribute("class").contains("active");
    }
}
