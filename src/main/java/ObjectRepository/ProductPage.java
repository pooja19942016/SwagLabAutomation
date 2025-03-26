package ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class ProductPage extends SeleniumUtilities
{
	@FindBy (className = "product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement LogoutBtn;
	
	@FindBy(id="shopping_cart_container") 
	private WebElement cartIcon;
	

 public ProductPage(WebDriver dirver)
 {
	PageFactory.initElements(dirver, this);  
 }


public WebElement getSortDropDown() {
	return sortDropDown;
}


public WebElement getMenuBtn() {
	return menuBtn;
}


public WebElement getLogoutBtn() {
	return LogoutBtn;
}


public WebElement getcartIcon() {
	return cartIcon;
}
/**
 * Busniess Library
 * This method is used to click on product read from excel file and return the details to caller
 * @param driver
 * @param PRODUCTNAME
 * @return
 */
public String clickOnProduct(WebDriver driver, String PRODUCTNAME) {
	WebElement prod = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
	String productDetails = prod.getText();
	prod.click();
	return productDetails;
	
}
/**
 * Busniess Library
 * This method is used to Logout
 */
public void Logout() {
	menuBtn.click();
	LogoutBtn.click();
	
}
/**
 * Busniess Library
 * This method is used to click on cart icon
 */
public void clickOnCartBtn() {
	cartIcon.click();
}
 /**
  * This method will sort the product and then click on required product and return the datails to caller 
  * @param driver
  * @param PRODUCTNAME
  * @param SORTOPTIONS
  * @return
  */
public String ClickOnSortDropDown(WebDriver driver,String PRODUCTNAME,String SORTOPTION) {
	handleDropdown(SORTOPTION,sortDropDown);
	WebElement prod = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
	String productDetails = prod.getText();
	prod.click();
	return productDetails;
}

public void clickOnCartIcon()
{
	cartIcon.click();
}

}
