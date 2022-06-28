package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * This class contains abstraction of low-level Selenium browser
 * automation code as a simple methods.
 *
 * @Author Meiramgul Altassova
 * @Date 05/22/2022
 */

public class Automations {

    private static WebDriver driver = DriverUtil.getDriver();
    private static WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));

    public static void init(WebDriver input) {
        driver = input;
        waits = new WebDriverWait(input, Duration.ofSeconds(15));
    }

    /**
     * Use this method to type into the element with provided text
     *
     * @param location By object
     * @param text String object
     */
    public static void type(By location, String text) {
        WebElement element =
                waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Use this method to determine whether an element extractable by the provided location
     * is visible to the ende user or not.
     *
     * @param location By object
     * @return boolean  true: element is visible,  false: element is not visible
     */
    public static boolean isVisible(By location) {
        WebElement element =
                waits.until( ExpectedConditions.visibilityOfElementLocated(location) );
        boolean result = element.isDisplayed();
        return result;
    }

    /**
     * Use this method to switch to desired tab that is open in
     * current browser session.  Make sure to provide unique text
     * that is found in the tab title.
     *
     * @param targetTitle String object
     */
    public static void switchToTab(String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String each : ids) {
            driver.switchTo().window(each);
            String title = driver.getTitle();
            if(title.contains(targetTitle)){
                break;
            }
        }//end::for
    }

    /**
     * Use this method to visit a particular site, note that
     * driver will wait all the site components is displayed
     * @param url
     */
    public static void visit(String url) {
        driver.get( url );
    }

    /**
     * Use this method to invoke a user click on the element
     * extractable by the provided location (coordinate)
     *
     * @param location By object
     */
    public static void click(By location) {
        WebElement element =
                waits.until(ExpectedConditions.elementToBeClickable(location));
        element.click();
    }

    /**
     * Use this method to grab the text content of the element
     * extractable by the provided location.
     *
     * @param location By object
     * @return String object
     */
    public static String getText(By location) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(location));
        String textContent = element.getText();
        return textContent;
    }

    /**
     * Use this method to put the Thread into sleep for specified
     * amount of time. Only use this method to demo the test execution
     * work-flow.
     *
     * @param sec
     */
    public static void sleep(int sec) {
        try{
            Thread.sleep(sec * 1000);
        }catch (InterruptedException ignore) {
            // DO-NOTHING
        }
    }
}//end::class
