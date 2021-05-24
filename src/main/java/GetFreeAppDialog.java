import org.openqa.selenium.By;

/**
 * @author Sargis Sargsyan on 5/20/21
 * @project picsart-internal-training
 */
public class GetFreeAppDialog extends BasePage{
    private By qrCode = By.cssSelector(".qrcode");

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isQrVisible() {
        return isDisplayed(qrCode);
    }


}
