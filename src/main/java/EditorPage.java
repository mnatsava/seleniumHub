import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sargis Sargsyan on 5/17/21
 * @project picsart-internal-training
 */
public class EditorPage extends BasePage {

    private static By instagramStoryLocation = By.cssSelector("[data-test='insta-story']");
    private static By editorItemLocation = By.cssSelector("[class*='customSizeContainer']");
    private static By fitIconLocation = By.cssSelector("#background-category");


    public EditorPage() {
        open(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/create/editor";
    }

    public int getItemsCount() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(editorItemLocation);
        return findAll(editorItemLocation).size();

    }

    public void clickInstagramStory() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(instagramStoryLocation);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(instagramStoryLocation)).click().build().perform();
    }
    public void clickFitIcon() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(fitIconLocation);
        click(fitIconLocation);
    }
}
