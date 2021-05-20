import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static SetUp.DriverSetup.getDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public static final String BASE_URL="http://picsart.com";

    public BasePage() {
        this.driver = getDriver();
    }

    public abstract String getUrl();

    public void open(String url) {
        System.out.println("Opening url -> " + url);
        driver.get(url);
    }

    public List<WebElement> findAll(By location) {
        System.out.println("Finding elements -> " + location.toString());
        return driver.findElements(location);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void type(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By locator) {
        click(getElement(locator));
    }

    public WebElement find(By location) {
        System.out.println("Finding element -> " + location.toString());
        return driver.findElement(location);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchFrameException e) {
            return false;
        }
    }

    public void changeTab(int tabIndex) {
        List<String> windowHandlers = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandlers.get(tabIndex));
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
