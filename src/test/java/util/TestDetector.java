package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestDetector implements ITestListener {

    private String path = System.getProperty("user.dir") + "/reports/";

    // --- Report related objects
    private ExtentReports reportManager;   // create report content
    private ExtentSparkReporter spark;     // theme, coloring
    private static ExtentTest testSection; // test case detailed section

    // ----- Methods for Test Context ( Smoke Test )

    @Override
    public void onStart(ITestContext context) {
        reportManager = new ExtentReports();
        spark = new ExtentSparkReporter(path);
        spark.config().setTimelineEnabled(true);
        reportManager.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext context) {
        reportManager.flush();
    }

    // ----- Methods for each test case

    @Override
    public void onTestStart(ITestResult result) {
        String testCaseName = result.getName();
        testSection = reportManager.createTest(testCaseName);
    }

    public static ExtentTest tcSection() {
        return testSection;
    }

    // ----- Methods for each test case ( after execution )

    @Override
    public void onTestSuccess(ITestResult result) {
        testSection.pass("This test has passed!");

        WebDriver driver = DriverUtil.getDriver();
        String picture = ( (TakesScreenshot)driver ).getScreenshotAs(OutputType.BASE64);
        testSection.addScreenCaptureFromBase64String(picture);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testSection.fail("This test case has failed!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testSection.skip("This test case is blocked!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // NO USE
    }
}
