/**
 * 
 */
package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import constants.Constants;
import pom.DashboardPage;
import singletonPattern.TestBase;
import utils.ReadExcel;

/**
 * @author SWAPNIL GOUR
 * This class contains tests w.r.t Dashboard Page
 *
 */
public class DashboardTest {

	DashboardPage page;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		TestBase.initialize();
		page = new DashboardPage(TestBase.driver);
		TestBase.loadApplication(Constants.APPLICATION_URL);
		page.implicitWait(10);
	}
	
	

	@Test(priority = 1)
	public void validEntryTest()
	{
		String username = "swapnil";
		String fullName = "Swapnil Gour";
		String password = "swapnil123";
		
		
		page.enterUsername(username);
		page.enterFullname(fullName);
		page.enterPassword(password);
		page.Submit();
		page.explicitlyWait(page.notify, 10);
		Assert.assertEquals(page.checkStatusText(),Constants.ruleSatisfiedFirst+username+Constants.ruleSatisfiedLast);
	}
	
	@Test(priority = 2)
	public void invalidEntryTest()
	{
		String username = "";
		String fullName = "";
		String password = "";
		
		
		page.enterUsername(username);
		page.enterFullname(fullName);
		page.enterPassword(password);
		page.Submit();
		page.explicitlyWait(page.notify, 10);
		Assert.assertEquals(page.checkStatusText(),Constants.ruleLoginNotEmpty);
	}
	
	@Test(priority = 3)
	public void weakPasswordTest()
	{
		String username = "swapnil";
		String fullName = "swapnil";
		String password = "swapnil";
		
		
		page.enterUsername(username);
		page.enterFullname(fullName);
		page.enterPassword(password);
		page.Submit();
		page.explicitlyWait(page.notify, 10);
		Assert.assertEquals(page.checkStatusText(),Constants.ruleNotSatisfied);
	}

	@Test(dataProvider = "getData", dataProviderClass = ReadExcel.class)
	public void multipleDataTest(String username , String fullName , String password)
	{
		
		page.enterUsername(username);
		page.enterFullname(fullName);
		page.enterPassword(password);
		page.Submit();
		page.explicitlyWait(page.notify, 10);
		Assert.assertEquals(page.checkStatusText(),Constants.ruleSatisfiedFirst+username+Constants.ruleSatisfiedLast);
	}
	
	@AfterClass
	public void tearDown()
	{
		TestBase.quit();
	}

}
