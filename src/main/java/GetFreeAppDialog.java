import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class GetFreeAppDialog extends BasePage {

    @FindBy(css = ".qrcode")
    private WebElement qrCode;

    public GetFreeAppDialog() {
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isQrVisible() {
        return isDisplayed(qrCode);
    }

}
