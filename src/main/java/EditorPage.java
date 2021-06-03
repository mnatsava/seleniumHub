import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class EditorPage extends BasePage {

    @FindBy(css = "[data-test='insta-story']")
    private WebElement instagramStory;

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> editorItemLocationList;

    @FindBy(css = "[class*='customSizeContainer']")
    private WebElement editorItem;

    @FindBy(css = "#background-category")
    private WebElement fitIcon;

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> itemsInSideBarList;

    @FindBy(css = "[class*='customSizeContainer']")
    private WebElement itemsInSideBar;


    public EditorPage() {
        open(getUrl());
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/create/editor";
    }

    public int getItemsCount() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(editorItem);
        return editorItemLocationList.size();

    }

    public void clickOnFitIcon() {
        click(fitIcon);
    }

    public void clickInstagramStory() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(instagramStory);
        Actions actions = new Actions(driver);
        actions.moveToElement(instagramStory).click().build().perform();
    }

    public int getCountOfItemsInSideBar() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(itemsInSideBar);
        return itemsInSideBarList.size();
    }

    public void clickFitIcon() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(fitIcon);
        click(fitIcon);
    }

}
