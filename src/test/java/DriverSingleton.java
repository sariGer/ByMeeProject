import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() {
        String type = BasePage.getData("browserType");
        if (driver == null) {
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
            } else if (type.equals("Edge")) {
                System.setProperty("webdriver.edge.driver", Constant.EDGEDRIVER_PATH);
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}
