package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    /*
     * 1. Valid data + Login Success  -> PASS -> Logout
     * 2. Valid data + Login Failure  -> FAIL
     * 3. Invalid data + Login Success -> FAIL -> Logout
     * 4. Invalid data + Login Failure -> PASS
     */

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")
    public void verify_loginDDT(String email, String pwd, String exp) {

        logger.info("*** Starting TC003_LoginDDT ***");

        try {

            // Home Page
            HomePage hp = new HomePage(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            // Login Page
            LoginPage lp = new LoginPage(driver);

            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clicklogin();

            // My Account Page
            MyAccountPage mac = new MyAccountPage(driver);

            boolean targetPage = mac.isMyAccountPageExists();

            // ---------------- VALID LOGIN ----------------
            if (exp.equalsIgnoreCase("Valid")) {

                if (targetPage) {

                    // Login successful -> PASS
                    Assert.assertTrue(true);

                    logger.info("Valid login successful.");

                    // Logout
                    hp.clickMyAccount();
                    mac.clickLogout();
                    mac.clickContinue1();

                    logger.info("Logged out successfully.");

                } else {

                    // Login failed when valid data was expected
                    logger.error("Valid login failed.");
                    //Assert.fail("Valid login failed.");
                    Assert.assertTrue(false);
                }
            }

            // ---------------- INVALID LOGIN ----------------
            else if (exp.equalsIgnoreCase("Invalid")) {

                if (targetPage) {

                    // Login successful with invalid data -> FAIL
                    logger.error("Invalid login data allowed login.");

                    // Logout because user is actually logged in
                    hp.clickMyAccount();
                    mac.clickLogout();
                    mac.clickContinue1();

                    //Assert.fail("Invalid login data successfully logged in.");
                    Assert.assertTrue(false);

                } else {

                    // Login failed with invalid data -> PASS
                    logger.info("Invalid login correctly rejected.");

                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {

            logger.error("Test failed due to exception.", e);
            Assert.fail("Exception occurred: " + e.getMessage());
        }

        logger.info("*** Finishing TC003_LoginDDT ***");
    }
}