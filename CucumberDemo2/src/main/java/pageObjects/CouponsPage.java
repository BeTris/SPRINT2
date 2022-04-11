package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CouponsPage {

	public WebDriver driver;
	
	By LoginNowbtn=By.xpath("//button[text()='Login Now']");
	By cleartrip=By.xpath("//a[@title = 'Buy Flight Ticket']");
	By Loginpopup=By.id("pb-login-auth-popup-form-comp");
	
	public CouponsPage(WebDriver driver) {

		this.driver=driver;
		
	}


	public WebElement getLoginNowbtn()
	{
		return driver.findElement(LoginNowbtn);
	}
	
	public WebElement getCleartrip()
	{
		return driver.findElement(cleartrip);
	}
	
	public WebElement getLoginpopup()
	{
		return driver.findElement(Loginpopup);
	}

	
	
	
}
