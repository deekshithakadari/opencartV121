package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='My Account']")   //visible after login successfully
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")   //logout-step6
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnContinue1;
	
	public boolean isMyAccountPageExists() {
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	public void clickContinue1() {
		btnContinue1.click();
	}

}
