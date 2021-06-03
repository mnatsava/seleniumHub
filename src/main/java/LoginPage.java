import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameFieldLocation;

    @FindBy(name = "password")
    private WebElement passwordFieldLocation;

    @FindBy(css = "[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']")
    private WebElement loginButtonLocation;

    @FindBy(css = ".pa-uiLib-authentication-btn.primary")
    private WebElement signInButtonLocation;

    @FindBy(css = ".pa-uiLib-headerProfileInfo-avatar")
    private WebElement avatarLocation;


    public LoginPage () {
        open(BASE_URL);
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    public void clickLoginButton() {
        click(loginButtonLocation);
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOf(usernameFieldLocation));
    }

    public void typeUsername(String username) {
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        type(passwordFieldLocation,password);
    }

    public void clickSignInButton() {
        click(signInButtonLocation);
    }

    public boolean isAvatarDisplayed() {
        return isDisplayed(avatarLocation);
    }

    public boolean isUserLoggedIn() {
        WebElement avatarIcon = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf((avatarLocation)));
        return avatarIcon.isDisplayed();
    }
}
