import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SendInformation extends BasePage {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void sendInformation() {
        pressRadioButtonNow();
        pickEmail();
        insertEmail();
        assertSenderName();
        continueToPayment();

    }

    //מתי לשלוח את המתנה? עכשיו
    private void pressRadioButtonNow() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.className("button-now"))));
        clickElement(By.className("button-now"));
    }

    //לחץ על מייל
    private void pickEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("svg[gtm=method-email]"))));
        clickElement(By.cssSelector("svg[gtm=method-email]"));
    }

    //הכנס מייל
    private void insertEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("sarifalk29@gmail.com");
    }

    //השוואה של שם השולח
    private void assertSenderName() {
        clearElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input"));
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input"), (Constant.name));
        String senderName = DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input")).getAttribute("value");
        Assert.assertEquals(senderName, Constant.name);
    }

    //המשך לתשלום
    private void continueToPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.className("bm-btn"))));
        clickElement(By.className("bm-btn"));
    }

}
