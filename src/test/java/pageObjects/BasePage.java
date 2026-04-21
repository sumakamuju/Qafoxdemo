package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;// class level variable declaration: web driver is interface and driver is reference variable
	
	public BasePage(WebDriver driver) //constructor to initiate driver
	{
		this.driver=driver;//assign the value of the constructor parameter driver to the class variable driver
		PageFactory.initElements(driver,this);//initElements applies driver to all the elements
		
	}
}
//fghvhvnb 