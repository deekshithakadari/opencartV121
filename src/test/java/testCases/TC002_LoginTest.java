package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("*** Starting TC_002_LoginTest ****");
		
		try
		{
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clicklogin();
			
			//MyAccountPage
			MyAccountPage mac=new MyAccountPage(driver);
			boolean targetPage=mac.isMyAccountPageExists();
			//Assert.assertEquals(targetPage, true,"Login Failed");  //if not true - then displays "login failed"
			Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****Finished loginpage success***");
	}

}
