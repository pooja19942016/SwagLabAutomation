package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *This calss consists of generic methods related to selenium 
 * @author pooja
 * */


public class SeleniumUtilities {
/**
 * This method will maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
/**
 * This method will minimize the window
 * @param driver
 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
/**
 * This method is for Implicit wait	
 * @param driver
 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
    /**
     * This method is for Explicit wait
     * @param driver
     * @param ele
     */
	public void WaitForElementToBeVisible(WebDriver driver,WebElement ele)
	{
	   WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
	   w.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * This method is for Explicit wait
	 * @param driver
	 * @param ele
	 */
	public void WaitForElementToBeClickable(WebDriver driver,WebElement ele)
	{
	   WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
	   w.until(ExpectedConditions.elementToBeClickable(ele));
	   
	}
	/**
	 * This method is for handling dropdown by index
	 * @param ele
	 * @param index
	 */
	public void handleDropdown(WebElement ele, int index)
	{
		Select s = new Select(ele);
		s.selectByIndex(index);
		
	}
	/**
	 * This method is for handling dropdown by value
	 * @param ele
	 * @param value
	 */
	public void handleDropdown(WebElement ele, String value)
	{
		Select s = new Select(ele);
		s.selectByValue(value);
		
	}
/**
 * This method is for handling dropdown by visibleText
 * @param visibletext
 * @param ele
 */
	public void handleDropdown(String visibletext,WebElement ele)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(visibletext);
	}

	/**
     * This method will perform double click action
     * @param driver
     * @param element
     */
	
	public void doubleClickAction(WebDriver driver, WebElement ele)
	{
	  Actions act = new Actions(driver);
	  act.doubleClick(ele).perform();
	  
	}
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver, WebElement ele)
	{
	  Actions act = new Actions(driver);
	  act.contextClick(ele).perform();
	  
	}
	/**
	 * This method is for Mouse hover Actions
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);
	}
	/**
	 * This is the method for drag and drop action
	 * @param driver
	 * @param src
	 * @param trg
	 */
	 public void dragAndDrop(WebDriver driver, WebElement src, WebElement trg)
	 {
		 Actions act = new Actions(driver);
		 act.dragAndDrop(src, trg).perform();
	 }
	 /**
	  * This method is for scrolling to element
	  * @param driver
	  * @param ele
	  */
	public void scrollToElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(ele);
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver , int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle frame by NAME or ID
	 * @param driver
	 * @param frameNameOrID
	 */
	public void handleFrame(WebDriver driver , String frameNameOrID)
	{
		driver.switchTo().frame(frameNameOrID);
	}
	
	
	/**
	 * This method will handle frame by frame element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver , WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will accept dismiss popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter data to alert popup
	 * @param driver
	 */
	public void enterTextAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will get text from alert popup
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will capture screenshot and return the absolute path to caller
	 * @param driver
	 * @param Screenshotname
	 * @return 
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String Screenshotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot\\"+Screenshotname+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //extent reports
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
