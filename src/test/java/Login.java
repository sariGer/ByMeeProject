import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login extends BasePage {
    public void login() {
        loginOrRegistration();
        registration();
        enterDetails();
    }

    //כניסה /הרשמה
    private void loginOrRegistration() {
        clickElement(By.className("notSigned"));
    }

    //להרשמה
    private void registration() {
        clickElement(By.className("text-link"));
    }

    private void enterDetails() {
        //הכנס שם
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input"),Constant.name);
        String findName = DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input")).getAttribute("value");
        Assert.assertEquals(Constant.name, findName);
        //הכנס מייל
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input"),Constant.email);
        String findEmail = DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input")).getAttribute("value");
        Assert.assertEquals(findEmail, Constant.email);
        //הכנס סיסמה
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input"),Constant.password);
        String findPassword = DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input")).getAttribute("value");
        Assert.assertEquals(findPassword, Constant.password);
        //הכנס אימות סיסמה
        sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input"),Constant.password);
        String findValidationPassword = DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input")).getAttribute("value");
        Assert.assertEquals(findValidationPassword, Constant.password);
        //כניסה לByMee
        clickElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button"));
    }
}



