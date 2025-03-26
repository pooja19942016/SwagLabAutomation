package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;

/**
 * This class consists of basic annotation of TestNG
 * @author pooja
 */
public class BaseClass {
	
	public SeleniumUtilities sUtil = new SeleniumUtilities();
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	public WebDriver driver;
	
	public static  WebDriver sdriver;
	
	@BeforeSuite
	//(groups={"SmokeSuite","RegressionSutie"})
	public void bsConfig() 
	{
		System.out.println("------Databse Connection successfull------");
	}
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String ParameterValue*/) throws IOException 
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		
		driver = new EdgeDriver(); //Base Browser
		
		//For CrossBowser Execution
//		if(ParameterValue.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(ParameterValue.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(ParameterValue.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
		
		
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver);
		driver.get(URL);
		System.out.println("------Browser launch Successfully------");
		
		//For listeners
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException 
	{ 
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("------Login of Application Successfully------");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() 
	{
		ProductPage pg = new ProductPage(driver);
		pg.Logout();
		System.out.println("------Logout Of Application Successfully------");
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void afConfig()
	{
		driver.quit();
		System.out.println("------Browser closure successfully------");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig() 
	{
		System.out.println("------Database closure Successfully------");
	}
	
	
}
