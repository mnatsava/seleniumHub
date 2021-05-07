import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TheFirstTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/mnats/Documents/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://picsartstage2.com");
        WebElement loginButton = chromeDriver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));

        loginButton.click();
        new WebDriverWait(chromeDriver, 5).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));

        WebElement usernameField = chromeDriver.findElement(By.name("username"));
        usernameField.sendKeys("mnatstest5");

        WebElement passwordField = chromeDriver.findElement(By.name("password"));
        passwordField.sendKeys("qwerty");

        WebElement signIn = chromeDriver.findElement(By.cssSelector(".pa-uiLib-authentication-btn.primary"));
        signIn.click();

        chromeDriver.quit();

    }
}
