package pages;

import org.openqa.selenium.By;
import static util.Automations.*;

/**
 * This page object class is representation of actual
 * Trello home page, any UI changes can be updated in this
 * one location.
 */

public class HomePage {
    private final String URL = "https://trello.com";

    // ---- List of element locations ---- //
    private final By loc_banner = By.cssSelector("h1");
    private final By loc_login_link = By.xpath("//a[text()='Log in']");
    private final By loc_features_tab = By.xpath("(//button[@data-testid='bignav-tab'])[1]");
    private final By loc_templates = By.xpath("(//div/p[text()='Templates'])[1]");

    // ---- Methods ( user's action ) ---- //

    /**
     * Use this method to open the trello test site
     * for the automation
     */
    public void open() {
        visit(URL);
    }

    /**
     * Use this method to determine whether the Trello home page
     * is displayed and visible to the user.
     *
     * @return  true: page is visible,  false: page is not visible
     */
    public boolean isDisplayed() {
        boolean result = isVisible(loc_banner);
        return result;
    }

    /**
     * This method will click the login link on home page.
     * Results in Login page display.
     */
    public void clickLogInLink() {
        click(loc_login_link);
    }

    /**
     * This method will click the Templates button on Features
     * section, results in Templates page display.
     */
    public void clickTemplates() {
        click(loc_features_tab);
        click(loc_templates);
    }

 }//end::class
