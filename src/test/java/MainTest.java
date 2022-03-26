import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class MainTest {
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");


    @BeforeClass
    public void beforeAll() {
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
        // screenshot
      //  test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());


    }

    @Test
    public void test01_assertionURL() {
        String byMeeURL = "https://buyme.co.il/";
        Assert.assertEquals(byMeeURL, DriverSingleton.getDriverInstance().getCurrentUrl());
    }

    @Test
    public void test02_login() {
        Login loginPage = new Login();
        loginPage.login();
    }

    @Test
    public void test03_homeScreen() throws InterruptedException {
        HomeScreen homeScreenPage = new HomeScreen();
        homeScreenPage.homeScreen();
    }

    @Test
    public void test04_assertionURLScreen3() {
        String byMeeURL3 = "https://buyme.co.il/search?budget=1&category=359&region=13";
        Assert.assertEquals(byMeeURL3, DriverSingleton.getDriverInstance().getCurrentUrl());

    }

    @Test
    public void test05_pickBusiness() {
        PickBusiness pickBusinessPage = new PickBusiness();
        pickBusinessPage.pickBusiness();

    }

    @Test
    public void test_06_receivedInformation() throws InterruptedException {
        ReceivedInformation receivedInformationPage = new ReceivedInformation();
        receivedInformationPage.receivedInformation();
    }

    @Test
    public void test_07_sendInformation() {
        SendInformation sendInformationPage = new SendInformation();
        sendInformationPage.sendInformation();
    }
}


/*
 private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    @BeforeClass
    public static void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");

        // log results
        test.log(Status.INFO, "@Before class");

        try {
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }

        driver.get("https://translate.google.com/");
    }

    @Test
    public void clickTextFieldTest() {
        try {
            driver.findElement(By.className("er8xn")).sendKeys("hello");
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Translate box was not clicked " + e.getMessage());
        }
    }

    @Test
    public void numberExceptionTest() {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            test.log(Status.FAIL, "NumberException " + e.getMessage());
        }
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();

    }

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
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

 */