package stepDefinitions;

//all import statements

//import io.cucumber.java.PendingException;
import pageObjects.*;
import org.testng.*;
import utils.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.*;

public class StepDefinitions extends InitializeWebDriver {
  
	@Before
    public void initializeWebDriver(Scenario currentScenario) {
        setCurrentScenario(currentScenario.getName());
    }

	
	//closes browser after screenshot capture
  @After
    public void closeAllBrowserWindows() {
        String ssPath = ScreenshotUtil.takeScreenshot(driver);
        ScreenshotUtil.setLastScreenshotFilename(ssPath);
        super.closeAllBrowserWindows();
    }


	//Initialize Web Driver
	@Given("Initialize the browser with Chrome")
	public void initialize_the_browser_with_chrome() throws Throwable {

		initializeWebDriver(); // taken from utils package
		System.out.println("Web Driver initialised SUCCESSFULL\n");

	}


	//Navigate to a particular site
	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
	
		//ProductsPage.navigateToLink(driver, strArg1); //taken from pageFactory package
							
		//Opens the link and maximises the window
		 driver.get(strArg1);
	     driver.manage().window().maximize();
		System.out.println("Navigated to the site SUCCESSFULLY\n");
    
	}


	//Scrolls down to view the product cards
	@Given("^Scroll down$")
	public void scroll_down() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,450)", "");						//scrolls in Y-axis
	     
	}


	//Perform click action on the first Product Card
	@When("Click on a product card")
	public void click_on_a_product_card()  {
		
		ProductsPage l0 = new ProductsPage(driver);
		l0.getProductImg().click(); 	   //performs click action
	           
	}
	
	
	//Verify that the product name in new product page is correct 
	@Then("^Verify that product name is correct in new page$")
	public void verify_that_product_name_is_correct_in_new_page() throws Throwable {
		
		ProductsPage l9 = new ProductsPage(driver);
		String str1 = "HP Metal Body 16 Gb Pen Drive";
		String str2 = l9.getProductName().getText(); //gets the PRODUCT NAME
		assertEquals(str1,str2);										  //test PASS when product name matches
	
	}
	
	
	//Perform click operation on right arrow
	@And("^We click on the right arrow beside picture$")
	public void we_click_on_the_right_arrow_beside_picture() throws Throwable {
	    
		ProductsPage l8 = new ProductsPage(driver);
		l8.getRarrow().click(); //performs click action
	
	}
	
	
	//Verify that picture changes when we click on right arrow
	@Then("^It takes us to the next picture of product$")
	public void it_takes_us_to_the_next_picture_of_product() throws Throwable {
	 
		ProductsPage l7 = new ProductsPage(driver);
		//WebElement l =driver.findElement(By.xpath("//*[@id=\"ProductDetailsId\"]/div/div[1]/div/div[2]/div/div/div[2]/img"));
		//WebElement l1 = driver.findElement(By.xpath("//*[@id=\"ProductDetailsId\"]/div/div[1]/div/div[1]/div/div/div[2]/img"));
	    String str = l7.getImg1().getAttribute("src");
	    String str2 = l7.getImg2().getAttribute("src");
	    System.out.println(str);				
	    System.out.println(str2);
	    assertEquals(str,str2);		/*after clicking on right arrow once the
									picture in focus and the 2nd picture are 
									same ( as they have same source )*/		
	 }
	
	
	//The product card should be clickable even on the text
	@Then("The product text should be clickable")
	public void the_product_text_should_be_clickable() throws Throwable {
		
		ProductsPage l6 = new ProductsPage(driver);
		String str = l6.getProdText().getAttribute("href"); //as the element should have a link it should have a href tag
		assertNotEquals(str,null); // when there is no href then test FAILS
	
	}
	
	
	//Scroll down to the footer of the product catalog page
	@When("^We scroll down to the footer$")
	public void we_scroll_down_to_the_footer() throws Throwable {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,5000)", ""); //Scroll down to the bottom of the page
	     
	}
	
	
	//The title of the page that opens when we click on "airmiles" should contain airmiles
	@Then("^Get the title of the page that opens$")
	public void get_the_title_of_the_page_that_opens() throws Throwable {
	    
		String str = driver.getTitle(); //get title of the window
	    if(str.contains("airmiles")) 	//if the title should contain the name of the company : airmiles
	    {								// test PASS
	    	Assert.assertTrue(true); 
	    }
	    else
	    	Assert.assertTrue(false);	//test FAILS
	
	}
	
	
	//Click on the link in footer named "air miles" in Product catalog page
	@And("^Click on the link air miles$")
	public void click_on_the_link_air_miles() throws Throwable {
		
		ProductsPage l5 = new ProductsPage(driver);
	//	driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/footer/div[2]/ul/li[2]/div/p[6]/a[11]")).click(); //perform click action
		l5.getAirmiles().click();
	}
	
	//Checks the action performed when we click on login . Either it should prompt us to login(PASS) or prompt us to enter valid quantity(FAIL) 
	@Then("^Prompts us to login$")
	public void prompts_us_to_login() throws Throwable {
		
		CouponsPage ll = new CouponsPage(driver);
		WebElement l1 = null;
		try{
			l1 = ll.getLoginpopup();//get element 
			if(l1!= null  )
				{
					System.out.println("prompts to login");
					Assert.assertTrue(true);//for successful prompt to login test PASSES
				
				}
		   }
		catch(NoSuchElementException e)
		{	
			//This happens when the quantity entered is not valid
			System.out.println("Prompts to enter valid quantity");
			Assert.assertTrue(false);//for invalid quantity test FAILS
		}
		finally 
		{
			//mandatory dummy finally 
			System.out.println("");
			//driver.quit();
		}
		
	}
	
	
	//Click on confirm button in "product page"
	@And("^Clicking on Confirm button$")
	public void clicking_on_confirm_button() throws Throwable {
		
		ProductsPage l3 = new ProductsPage(driver);
		l3.getBtn1().click();						//performs click action
	
	}
	
	
	//Enter quantity
	@And("^then click on inputbox to enter (.+)$")
	public void then_click_on_inputbox_to_enter(String quantity) throws Throwable {
		
		ProductsPage l2 = new ProductsPage(driver);
		l2.getQuant().clear();
		l2.getQuant().sendKeys(quantity);
		
	}
	
	
	//Scroll down to show the link "clear trip"
	@When("^Scroll down to cleartrip$")
	public void scroll_down_to_cleartrip() throws Throwable {
	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeScript("window.scrollBy(0,2500)", ""); //scrolls down in the Y-axis
		
	}
	
	
	//Verify that the "clear trip window" contains the text "cleartrip" and thus is a right working link
	@Then("^Verify that the page has elements present$")
	public void verify_that_the_page_has_elements_present() throws Throwable {
	
		/*Set<String> windows = driver.getWindowHandles(); //[parentId, childId ,subchildId]
		//Get parent and child window id
		Iterator<String>it = windows.iterator();
		//String parentId = it.next(); // get parentId
		String childId = it.next(); //get childId
		driver.switchTo().window(childId);//switch to child window
		
		//now handle is in child window
		if(driver.getPageSource().contains("cleartrip")) 
			 Assert.assertTrue(true); //TESTCASE PASSES if new page contains the text "cleartrip"
		else
			 Assert.assertTrue(false); //TESTCASE FAILS if new page does not contain the text "cleartrip"
	}*/
		CouponsPage l1 = new CouponsPage(driver);
		  // l1.getCleartrip().click();//performs click action
		String url = l1.getCleartrip().getAttribute("href");

		HttpURLConnection huc = null;
		int respCode = 200;
		try {
		huc = (HttpURLConnection)(new URL(url).openConnection());

		huc.setRequestMethod("HEAD");

		huc.connect();

		respCode = huc.getResponseCode();

		if(respCode >= 400){
		System.out.println(url+" is a broken link");
		Assert.assertTrue(false);
		}
		else{
		System.out.println(url+" is a valid link");
		Assert.assertTrue(false);
		}

		} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

	}
	
	
	//Click on the "cleartrip" link in Coupons page
	@And("^Click on the Cleartrip hyper link$")
	public void click_on_the_cleartrip_hyper_link() throws Throwable {
		
		CouponsPage l1 = new CouponsPage(driver);
	    l1.getCleartrip().click();//performs click action
	
	}
	
	
	//Scroll down to view "Login Now" button in Coupons page
	@When("^Scroll down to login$")
	public void scroll_down_to_login() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver; //creating JavascriptExecutor object by type-casting web driver
	    js.executeScript("window.scrollBy(0,500)", ""); //scrolls down along Y-axis
	
	}
	
	
	//Click on " login now " button in coupons page
	@And("^Click on Login Now button$")
	public void click_on_login_now_button() throws Throwable {
	    CouponsPage l = new CouponsPage(driver);
		l.getLoginNowbtn().click(); //performs click action
	}

}


    
 
	