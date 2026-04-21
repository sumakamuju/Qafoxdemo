package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
			}
@FindBy(xpath="//*[@id=\"input-email\"]")
WebElement txtemailaddress;
@FindBy(xpath="//*[@id=\"input-password\"]")
WebElement txtpassword;
@FindBy(xpath="//*[@type='submit']")
WebElement btnsubmitlogin;

public void setEmail(String email)
{
	txtemailaddress.sendKeys(email);
}
public void setPassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void clickSubmitLogin()
{
	btnsubmitlogin.click();
}
	
	
}
