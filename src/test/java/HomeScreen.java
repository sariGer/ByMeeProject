import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeScreen extends BasePage {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void homeScreen() throws InterruptedException {

        price();
        region();
        category();
        findPresentToMe();
    }

    //בחר סכום
    private void price() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=סכום]"))));
        clickElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1064")));
        clickElement(By.id("ember1064"));
    }

    //בחר אזור
    private void region() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=אזור]"))));
        clickElement(By.cssSelector("span[alt=אזור]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1099")));
        clickElement(By.id("ember1099"));

    }

    //בחר קטגוריה
    private void category() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=קטגוריה]"))));
       clickElement(By.cssSelector("span[alt=קטגוריה]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1160")));
        clickElement(By.id("ember1160"));
    }

    //תמצאו לי מתנה
    private void findPresentToMe() throws InterruptedException {
        clickElement(By.id("ember1188"));
    }
}