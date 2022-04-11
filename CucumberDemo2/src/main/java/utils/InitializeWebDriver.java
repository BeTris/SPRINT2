package utils;

//import statements
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class InitializeWebDriver 
{
	private static final ThreadLocal<String> currentScenario = new ThreadLocal<>();
	//declare driver and properties
    public WebDriver driver;
    public Properties prop;
    
    public static void setCurrentScenario(String currentScenario) {
        InitializeWebDriver.currentScenario.set(currentScenario);
    }

    public static String getCurrentScenario() {
        return currentScenario.get();
    }

    public WebDriver initializeWebDriver() throws IOException
    {
    	
    	prop= new Properties();
	    FileInputStream fis=new FileInputStream("C:\\Users\\meghn\\Desktop\\MavenCucumberDemo-main\\src\\main\\java\\utils\\data.properties");
	    prop.load(fis);
	    String browserName=prop.getProperty("browser");					//get the browser name from data.properties
	    System.out.println("Browser name is set to : " + browserName);	//print the browser name
	
	    if(browserName.equals("chrome"))
	    {
	    																//execute when browser is chrome 
	    	 ChromeOptions options = new ChromeOptions();
	    	 options.addArguments("--disable-notifications");
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\meghn\\Desktop\\SPRINT 2\\chromedriver.exe");  
	    	 driver= new ChromeDriver(options);
	    		
	    }
	
	    else if (browserName.equals("firefox"))
	    {
	    																//execute when browser is firefox
	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\meghn\\Desktop\\SPRINT 2\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	
	    }
	    else if (browserName.equals("IE"))
	    {
	    																////execute when browser is msedge
	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\meghn\\Desktop\\SPRINT 2\\msedgedriver.exe");
	    	driver = new EdgeDriver();
	    	
	    }
	    
	    //the browser instance is returned
	    return driver;

    }
   
    public void closeAllBrowserWindows() {
        driver.quit();
    }
}





