package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	//1.CONSTRUCTOR
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
//2.LOCATORS
	@FindBy(xpath="//*[text()='My Account']")
	WebElement My_Account;
	@FindBy(xpath="//*[text()='Register']")
	WebElement Register;
	@FindBy(xpath="//*[text()='Login']")
	WebElement Login;
	
	
//3.ACTION METHODS
	public void clickMyAccount()
	{
		My_Account.click();
	}
	public void clickRegister()
	{
		Register.click();
	}
	public void clickLogin()
	{
		Login.click();
	}
	
}

