import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public void clearElement(By locator) {
        getWebElement(locator).clear();
    }
    public WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}