package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class contains driver related common methods
 * that will be used in test scripts
 *
 * @Author Meiramgul Altassova
 * @Date 05/22/2022
 */
public class DriverUtil {

    private static WebDriver driver;

    /**
     * Use this method to establish driver-->browser
     * connection. This method will produce one driver
     * object when its invoked.
     */

    public static void openBrowser(String browserType) {
        System.out.println("\n\n===================ALPHALEAF=============================");
        System.out.println("Hey guys! Alphaleaf Students!!");
        System.out.println("If you see this message, that means that ");
        System.out.println("Our automation framework was executed.");
        System.out.println("===================ALPHALEAF=============================\n\n");

        boolean isChrome = browserType.equalsIgnoreCase("chrome");
        boolean isFirefox = browserType.equalsIgnoreCase("firefox");
        boolean isEdge = browserType.equalsIgnoreCase("edge");
        boolean isHeadless = browserType.equalsIgnoreCase("headless");

        if(isChrome) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(isFirefox) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(isEdge) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(isHeadless) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
        }else {
            // default, browserType does not make sense
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    /**
     * Use this method to get access to driver object currently
     * connected to driver executable.
     *
     * @return WebDriver object
     */

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Use this to close the [driver]-->[browser] connection.
     */
    public static void closeBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }

}//end::