package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage (WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkpolicy;

@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstname(String fname) {
	txtFirstname.sendKeys(fname);
}
public void setLastname(String lname) {
	txtLastname.sendKeys(lname);
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
}
public void setPassword(String pwd) {
	txtpassword.sendKeys(pwd);
}
public void setPrivacyPolicy() {
	//chkpolicy.click();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",chkpolicy);
}
public void clickContinue() {
	//Method-1
	//btnContinue.click();
	
	//Method-2
	//btnContinue.submit();
	
	//Method-3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
	
	//Method-4
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",btnContinue);
	
	//Method-5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//Method-6
	//WebDriverWait wait= new WebDrivrWait(driver,Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}
	catch(Exception e) {
		return (e.getMessage());
	}
}

}
