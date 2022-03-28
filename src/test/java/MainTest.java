import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class MainTest {
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    @BeforeClass
    public void beforeAll() {
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String cwd = System.getProperty("user.dir");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html" + (dateFormat.format(date)));

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("first report", "sample description");
        //ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        //extent.attachReporter(htmlReporter);
        //test.log(Status.INFO, "before test method");

        //screenshot
        //  test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());
    }

    @Test

    public void test01_assertionURL() {
        try {
            String byMeeURL = "https://buyme.co.il/";
            Assert.assertEquals(byMeeURL, DriverSingleton.getDriverInstance().getCurrentUrl());
            //  test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Translate box was not clicked " + e.getMessage());
        }
    }

    @Test
    public void test02_login() {
        try {
            Login loginPage = new Login();
            loginPage.login();
            test.log(Status.PASS, "test 1 passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 1 failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test
    public void test03_homeScreen() throws InterruptedException {
        try {
            HomeScreen homeScreenPage = new HomeScreen();
            homeScreenPage.homeScreen();
            test.pass("test 2 passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 2 failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test
    public void test04_assertionURLScreen3() {
        try {
            String byMeeURL3 = "https://buyme.co.il/search?budget=1&category=359&region=13";
            Assert.assertEquals(byMeeURL3, DriverSingleton.getDriverInstance().getCurrentUrl());
            test.pass("test 3 passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 3 failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }

    }

    @Test
    public void test05_pickBusiness() {
        try {
            PickBusiness pickBusinessPage = new PickBusiness();
            pickBusinessPage.pickBusiness();
            test.pass("test 4 passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 4 failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }

    }

    @Test
    public void test_06_receivedInformation() throws InterruptedException {
        try {
            ReceivedInformation receivedInformationPage = new ReceivedInformation();
            receivedInformationPage.receivedInformation();
            test.pass("test 5 passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 5 failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test
    public void test_07_sendInformation() {
        try {
            SendInformation sendInformationPage = new SendInformation();
            sendInformationPage.sendInformation();
            test.pass("test 6 passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 6 failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        DriverSingleton.getDriverInstance().quit();
        // build and flush report
        extent.flush();

    }

    //פונקצית תשתית ליצירת צילומי מסך
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}

