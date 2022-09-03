/**
 * 
 */
package singletonPattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constants;

/**
 * @author SWAPNIL GOUR
 *
 */
public class TestBase 
{
	public static WebDriver driver = null;
	 
    // Declaring constructor as private to restrict object creation outside of class
    private TestBase()
    {
        System.out.println("TestBase Object created.");
    }

    @SuppressWarnings("deprecation")
	public static void initialize()
    {
        if (driver == null)
        {
        	if(Constants.browserName.equalsIgnoreCase("Chrome"))
			{
        		System.out.println("Welcome to Chrome Browser");
        		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\chromedriver.exe");
        		driver = new ChromeDriver();
			}
        	if(Constants.browserName.equalsIgnoreCase("Firefox"))
			{
        		System.out.println("Welcome to Firefox Browser");
        		System.setProperty("webdriver.gecko.driver", "src\\main\\java\\resources\\drivers\\");
        		driver = new ChromeDriver();
			}
        			
        }
        
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
     }
    
    //Closes all the browsers windows
    public static void quit()
    {
    	System.out.println("Quitting the browsers");
    	driver.quit();
    	driver=null;
    }
    
  //Closes only the  the browsers
    public static void close()
    {
    	System.out.println("Closing the browsers window");
    	driver.quit();
    	driver=null;
    }
    
	 public static void loadApplication(String url)
	 {
		 driver.get(url);
	 }
}