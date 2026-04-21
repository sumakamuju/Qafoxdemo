package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		}
@FindBy(xpath="//*[@id=\"input-firstname\"]")
private WebElement txtFirstname;
@FindBy(xpath="//*[@id=\"input-lastname\"]")
WebElement txtLastname;
@FindBy(xpath="//*[@id=\"input-email\"]")
WebElement txtEmailid;
@FindBy(xpath="//*[@id=\"input-telephone\"]")
WebElement txtTelephone;
@FindBy(xpath="//*[@id=\"input-password\"]")
WebElement txtPassword;
@FindBy(xpath="//*[@id=\"input-confirm\"]")
WebElement txtConfirmpassword;
@FindBy(xpath="//*[text()='No']")
WebElement btnRdio;
@FindBy(xpath="//*[@name=\"agree\"]")
WebElement chkPolicy; 
@FindBy(xpath="//*[@value=\"Continue\"]")
WebElement btnContinue;
@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
WebElement msgConfirmation;


public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);}
public void setLastName(String lname){
	txtLastname.sendKeys(lname);}
public void setEmail(String email) {
	txtEmailid.sendKeys(email);}
public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);}
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);}
public void setConfirmPassword(String pwd) {
	txtConfirmpassword.sendKeys(pwd);}
public void clickSubscribe() {
	btnRdio.click();}
public void setPrivacyPolicy() {
	chkPolicy.click();}
public void clickContinue() {
	btnContinue.click();}


public String getConfirmationMsg() {
	try {
		return(msgConfirmation.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
}
}














