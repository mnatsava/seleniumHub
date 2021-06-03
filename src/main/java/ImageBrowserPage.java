import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class ImageBrowserPage extends BasePage {

    @FindBy(css = ".actions-section .notifier-hover-toggle .like")
    private WebElement likeIconLocation;

//
//    public ImageBrowserPage () {
//        PageFactory.initElements(getDriver(), ImageBrowserPage.class);
//    }

    public ImageBrowserPage (String imageID) {
        open(BASE_URL + "/i/" + imageID);
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickOnLikeIcon() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(likeIconLocation);
        click(likeIconLocation);
    }

    public boolean isHashtagByNameVisible(String hashtagName) {
        //TODO need to implement
        return true;
    }

    public boolean isImageLiked() {
        return likeIconLocation.getAttribute("class").contains("active");
    }
}
