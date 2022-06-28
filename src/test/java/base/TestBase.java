package base;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import util.Automations;
import util.DriverUtil;

/**
 * This is a parent class for all the Test Class.
 * It contains commonly used methods between each UI test case
 */
public class TestBase {

    private HomePage homePage;
    private LoginPage loginPage;
    private Faker faker;

    /**
     * Use this method to get access to the random
     * test data generator object called Faker
     *
     * @return Faker object
     */
    public Faker data() {
        boolean isFakerEmpty = (faker == null);
        if(isFakerEmpty) {
            faker = new Faker();
            return faker;
        }
        return faker;
    }

    /**
     * Use this method to get access to the HomePage object
     * in your test case.
     *
     * @return
     */

    public HomePage home() {
        boolean homePageIsEmpty = (homePage == null);
        if (homePageIsEmpty) {
            homePage = new HomePage();
            return homePage;
        }
        return homePage;
    }

    /**
     * Use this method to get access to the LoinPage object
     * in your test case
     *
     * @return LoginPage object
     */
    public LoginPage login() {
        boolean loginPageIsEmpty = (loginPage == null);
        if(loginPageIsEmpty) {
            loginPage = new LoginPage();
            return loginPage;
        }
        return loginPage;
    }

    @BeforeMethod
    public void setUp() {
        String cmdVarBrowser = System.getProperty("browser");
        DriverUtil.openBrowser(cmdVarBrowser);
        Automations.init(DriverUtil.getDriver());
    }

    @AfterMethod
    public void cleanUp() {
        DriverUtil.closeBrowser();
    }
}//end::class
