package browserdriverssetup;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BrowserDriverSetUp {
    public static WebDriver driver = null;
    public static final String url = System.getProperty("url", "http://54.172.98.170:443/");
    public static String browserName = System.getProperty("browserName", "chrome");
    public static String os = System.getProperty("os", "mac");
    public static String platform = System.getProperty("platform", "local"); //changed from local to cloud in order to get into cloud
    public static String cloudPlatformName = System.getProperty("cloudPlatformName", "browserstack");
    public static final String AUTOMATE_USERNAME = System.getProperty("AUTOMATE_USERNAME", "danishbangash_rRCuWh");
    public static final String AUTOMATIVE_ACCESS_KEY = System.getProperty("AUTOMATE_ACCESS_KEY", "WE7vT53aUb3UBUtCce9n");
//Start Of Reporting Utilities

    //ExtentReport

    public static ExtentReports extent;
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/Desktop/" + screenshotName + " " + df.format(date) + ".png"));
//            System.out.println("Screenshot captured");
//        } catch (Exception e) {
//            System.out.println("Exception while taking screenshot " + e.getMessage());;
//        }

    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    //End Of Reporting Utilities

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        if (platform.equals("local")) {
            if (browserName.equals("chrome")) {
                getChromeDriver();
            }
        } else if (browserName.equals("firefox")){
            getFireFoxDriver();
        }
            else if (platform.equals("cloud")) {
            if (cloudPlatformName.equals("browserstack")) {
                getDriverForBrowserStack();
            }
        }
        driver.get(url);
    }
    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximixed");
        options.addArguments("incognito");
        if (os.equals("mac")){
            System.setProperty("webdriver.chrome.driver","../Utilities/Drivers/Mac/chromedriver");
            driver = new ChromeDriver(options);
        } else if (os.equals("windows")){
            System.setProperty("webdriver.chrome.driver","../Utilities/Drivers/Windows/chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
    public static WebDriver getFireFoxDriver(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("private");
        options.addArguments("ignore-certificate-errors");
        if (os.equals("mac")){
            System.setProperty("webdriver.gecko.driver", "../Utilities/Drivers/Mac/geckodriver");
            driver = new FirefoxDriver(options);
        } else if (os.equals("windows")){
            System.setProperty("webdriver.gecko.driver", "..Utilities/Drivers/Windows/geckodriver.exe");
            driver = new FirefoxDriver(options);
        }
        return driver;
    }
    public static WebDriver getDriverForBrowserStack() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version","Big Sur");
        caps.setCapability("resolution","1920 x 1080");
        caps.setCapability("browser","chrome");
        caps.setCapability("browser_version","92.0");
        caps.setCapability("os","OS X");

        URL remoteAddress;
        driver = new RemoteWebDriver(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATIVE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"),caps);
        return driver;
    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
