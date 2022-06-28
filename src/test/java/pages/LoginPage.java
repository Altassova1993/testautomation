package pages;

import org.openqa.selenium.By;
import static util.Automations.*;

/**
 * This page object class represents Trello Login page
 * ny changes in elements and user actions should be
 * updated in here
 */
public class LoginPage {

    // ---- List of elements ---- //

    private final By loc_email = By.cssSelector("input#user");
    private final By loc_pass = By.cssSelector("input#password");
    private final By loc_login_button = By.cssSelector("input#login");
    private final By loc_error_message = By.cssSelector("div#error > p");


    // ---- Methods ( user's action ) ---- //

    /**
     * Use this method to simulate user login on Trello
     *
     * @param username  String:   valid username
     * @param password  String:   valid password
     */
    public void signInWith(String username, String password) {
        type(loc_email, username);
        type(loc_pass, password);
        click(loc_login_button);

    }

    /**
     * Use this method to extract carious error message related to
     * user login from login page.
     *
     * @return String: error message displayed
     */
    public String getErrorMessage() {
        String content = getText(loc_error_message);
        return content;
    }

}
