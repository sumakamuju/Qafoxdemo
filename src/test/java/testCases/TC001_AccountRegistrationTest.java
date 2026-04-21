package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
	logger.info("****** Starting TC001_AccountResgistrationTest ******");
	try {
	HomePage hp=new HomePage(driver);//object for Home page class
	hp.clickMyAccount();
	logger.info("Clicked on myAccount link");
	hp.clickRegister();
	logger.info("Clicked on Register link");
	RegistrationPage regpage=new RegistrationPage(driver); //object for Registration page class
	logger.info("Customer details");
	regpage.setFirstName(randomString().toUpperCase());
	regpage.setLastName(randomString().toUpperCase());
	regpage.setEmail(randomString()+"@gmail.com");//randomly generate the email 
	regpage.setTelephone(randomNumber());
	
	String password=randomAlphaNumeric();//for random password
	regpage.setPassword(password);
	regpage.setConfirmPassword(password);
	
	regpage.setPrivacyPolicy();
	regpage.clickContinue();
	logger.info("Validating expected message..");
	String confmsg=regpage.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	System.out.println(confmsg);
	
	}
	catch(Exception e) {
		logger.error("Test failed..");
		logger.debug("Debug logs..");
		Assert.fail();
	}
		
	}
	
}
	
	
	

