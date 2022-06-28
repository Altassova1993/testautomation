package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test class contains test cases designated for
 * build verification test.
 */
@Listeners(util.TestDetector.class)
public class SmokeTest extends TestBase {

    @Test
    public void verifyInvalidLoginResultsInErrorMessage() {
        // -- Test Data -- //
        String invalidUser = data().internet().emailAddress();
        String invalidPass = data().internet().password();
        String expected = "There isn't an account for this email";

        // -- Test Script -- //
        home().open();
        home().clickLogInLink();

        login().signInWith(invalidUser, invalidPass);
        String actual = login().getErrorMessage();

        // -- Test Assertion -- //
        Assert.assertEquals(actual, expected);
    }
}//end::class
