import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class CreatePage extends BasePage {

    @FindBy(css = "[class*='uploadButton'] input")
    private WebElement uploadButtonLocation;

    @FindBy(css = "[data-test='insta-story']")
    private WebElement instagramStory;

    public CreatePage() {
        open(getUrl());
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/create";
    }

    public void open() {
        open(getUrl());
    }

    public EditorPage clickInstagramStory() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(instagramStory).click().build().perform();
        return new EditorPage();
    }

    public void uploadPhoto() {
//        WaitHelper.getInstance().waitForElementToBeDisplayed(uploadButtonLocation);
        type(uploadButtonLocation, "/Users/mnats/IdeaProjects/SeleniumDemo/src/main/resources/photo.png");
    }
}
