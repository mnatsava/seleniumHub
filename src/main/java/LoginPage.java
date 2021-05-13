import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By signInButtonLocator = By.cssSelector(".pa-uiLib-authentication-btn.primary");
    private By avatarLocator = By.cssSelector((".pa-uiLib-headerProfileInfo-profileInfo"));


    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));
    }

    public void typeUsername(String username) {
        WebElement usernameField = driver.findElement(usernameLocator);
        usernameField.sendKeys(username);
    }

    public void typePassword(String password) {
        WebElement usernameField = driver.findElement(passwordLocator);
        usernameField.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();
    }

    public boolean isLoggedIn() {
        WebElement avatar = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(avatarLocator));
        return avatar.isDisplayed();
    }
}
