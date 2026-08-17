package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Sanity","Regression","Master"})
	public void verify_account_registration() {
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link...");
		hp.clickRegister();
		logger.info("Clicked on Register link...");
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		repage.setFirstname(randomeString().toUpperCase());  
		repage.setLastname(randomeString().toUpperCase());
		repage.setEmail(randomeString()+"@gmail.com");   //randomly generating the email
		String password=randomeAlphaNumeric();
		repage.setPassword(password);
		repage.setPrivacyPolicy();
		repage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg = repage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");  //validation , wantedly gave wrong
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC001_AccountRegistrationTest *****");
	}
}
