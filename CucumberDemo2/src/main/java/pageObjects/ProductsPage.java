package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

public WebDriver driver;
	
	By productImg = By.className("img-responsive");
	By productName = By.id("productname");
	By rarrow = By.xpath("//button[@aria-label='Next']");
	By img1 = By.xpath("//*[@class='img-responsive' and @src='https://www.perfume2order.com/pb_ext_image/product_detail/main_image/16282.jpg']");
	By img2 = By.xpath("//*[@class='img-responsive' and @src='https://www.perfume2order.com/pb_ext_image/product_detail/main_image/16282.jpg']");
	By prodText = By.className("pb-recommended-desc");
	By airmiles = By.xpath("//a[text()='air miles']");
	By btn1 = By.id("redeemBtn");
	By btn2 = By.id("redeemBtn");
	By quant = By.xpath("//input[@maxlength='3' or @class='pb-qty-input number-input pb-quantity-input']");
	
	public ProductsPage(WebDriver driver) {

		this.driver=driver;
		
	}

	
	public WebElement getProductImg() {
		return driver.findElement(productImg);
	}
	
	public WebElement getProductName() {
		return driver.findElement(productName);
	}

	public WebElement getRarrow() {
		return driver.findElement(rarrow);
	}

	public WebElement getImg1() {
		return driver.findElement(img1);
	}

	public WebElement getImg2() {
		return driver.findElement(img2);
	}

	public WebElement getProdText() {
		return driver.findElement(prodText);
	}

	public WebElement getAirmiles() {
		return driver.findElement(airmiles);
	}

	public WebElement getBtn1() {
		return driver.findElement(btn1);
	}

	
	public WebElement getBtn2() {
		return driver.findElement(btn2);
	}
	
	
	public WebElement getQuant() {
		return driver.findElement(quant);
	}



















































	


	
}
