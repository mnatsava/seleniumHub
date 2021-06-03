import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class ChallengePage extends BasePage {

    @FindBy(css = ".c-get-the-app-popup.primary-big-btn")
    private WebElement participateButtonLocation;

    public ChallengePage(String id) {
        open(getUrl() + "/" + id);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/challenge";
    }

    public GetFreeAppDialog clickParticipate() {
        WaitHelper.getInstance().waitForElementToBeDisplayed(participateButtonLocation);
        click(participateButtonLocation);
        return new GetFreeAppDialog();
    }

}
