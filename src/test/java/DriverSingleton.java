import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Desktop\\automation\\ChromeDriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }
}
