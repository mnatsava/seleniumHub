import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static setup.DriverSetup.getDriver;

/**
 * @author Sargis Sargsyan on 5/13/21
 * @project picsart-internal-training
 */
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

    public WebElement find(By location) {
        System.out.println("Finding element -> " + location.toString());
        return driver.findElement(location);
    }
    public List<WebElement> findAll(By location) {
        System.out.println("Finding elements -> " + location.toString());
        return driver.findElements(location);
    }

    public void type(By location, String text) {
        type(find(location), text);
    }

    public void type(WebElement element, String text) {
        System.out.println("Typing " + text +" to field  -> " + element.toString());
        element.sendKeys(text);
    }

    public void click(By location) {
        System.out.println("Clicking on element -> " + location.toString());
        click(find(location));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void changeTab(int tabIndex) {
        List<String> windowHandlers = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandlers.get(tabIndex));
    }


    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
