/**
 * 
 */
package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

/**
 * @author SWAPNIL GOUR
 *
 */
public class DashboardPage {

	/**
	 * @param args
	 */
	WebDriver driver;
    Properties prop = ReadPropertiesFileTest.readPropertiesFile(Constants.filePath);
    
    public By userName = By.id(prop.getProperty("usernameID"));
    public By fullName = By.xpath(prop.getProperty("fullnameXpath"));
    public By password = By.name(prop.getProperty("passwordName"));   
    public By loginButton = By.id(prop.getProperty("loginButtonID"));
    public By status = By.id(prop.getProperty("statusID"));   
    public By notify = By.id(prop.getProperty("notifyID"));
    
    

    public DashboardPage(WebDriver driver) throws IOException{

        this.driver = driver;

    }
    
    public void enterUsername (String value)
    {
    	try 
    	{
    		
    		locateElement(userName).click();
        	locateElement(userName).clear();
        	locateElement(userName).sendKeys(value);
        	System.out.println("Entered User Name as "+value);
			
		} catch (NoSuchElementException e) 
    	{
			System.out.println(e.toString());
		
		}
    	catch (Exception e) 
    	{
			System.out.println(e.toString());
		
		}
    	
    }
    
    public void enterFullname (String value)
    {
    	try 
    	{
    		locateElement(fullName).click();
        	locateElement(fullName).clear();
        	locateElement(fullName).sendKeys(value);
        	System.out.println("Entered fullName as "+value);
			
		} catch (NoSuchElementException e) 
    	{
			System.out.println(e.toString());
		
		}
    	catch (Exception e) 
    	{
			System.out.println(e.toString());
		
		}
    }
    
    public void enterPassword (String value)
    {
    	try 
    	{
    		locateElement(password).click();
        	locateElement(password).clear();
        	locateElement(password).sendKeys(value);
        	System.out.println("Entered password");
			
		} catch (NoSuchElementException e) 
    	{
			System.out.println(e.toString());
		
		}
    	catch (Exception e) 
    	{
			System.out.println(e.toString());
		
		}
    }
    
    public void Submit ()
    {
    	try 
    	{
    		locateElement(loginButton).click();
        	
		} catch (NoSuchElementException e) 
    	{
			System.out.println(e.toString());
		
		}
    	catch (ElementClickInterceptedException e) 
    	{
			System.out.println(e.toString());
		}
    	catch (Exception e) 
    	{
			System.out.println(e.toString());
		
		}
    }
    
    public String checkStatusText()
    {
    	return locateElement(status).getText();
    }
    
    public String notificationText()
    {
    	return locateElement(notify).getText();
    }
    
	 public WebElement locateElement (By element)
	 {
		 return driver.findElement(element);
	 }
	 
	 
	 public void implicitWait(int seconds)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	 }
	 
	 public void explicitlyWait(By element, int seconds)
	 {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	 }
	 
	 public void fluintWait(int seconds, int polling)
	 {
		 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			        .withTimeout(Duration.ofSeconds(seconds))
			        .pollingEvery(Duration.ofSeconds(polling));
	 }
}
