 package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
 
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp)  {
	logger.info("starting TC003_LoginData");
	//HomePage
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
			
	//LoginPage
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty(email));
	lp.setPassword(p.getProperty(pwd));
	lp.clickSubmitLogin();
			
	//MyAccountPage
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	if(exp.equalsIgnoreCase("Valid"))	
	{
		if(targetPage==true)
		{
			macc.clickLogOut();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			macc.clickLogOut();
			Assert.assertTrue(false);
			}
		else
		{
			Assert.assertTrue(true);
		}
		logger.info("finished TC003_LoginData");	
		}
	
}
	
	
		
	
	
}
