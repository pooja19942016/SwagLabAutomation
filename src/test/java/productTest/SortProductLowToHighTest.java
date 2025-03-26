package productTest;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtilities;
@Listeners(genericUtilities.ListenersImplementation.class)
public class SortProductLowToHighTest extends BaseClass {
//	public static void main(String[] args) throws IOException, InterruptedException 
	@Test(groups={"SmokeSutie",""})
	public void tc_002_Sorting_PRoductPrice() throws IOException
	{

		String SORTOPTION = fUtil.readDataFromExcel("Products", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 4, 3);
		
		//Navigate to Product and click on the product
		ProductPage p = new ProductPage(driver);
		String prodAdded = p.ClickOnSortDropDown(driver, PRODUCTNAME, SORTOPTION);

		//Add Product to cart
		InventoryItemPage c = new InventoryItemPage(driver);
		c.clickOnAddToCartBtn();
		
		//Navigate to cart
		p.clickOnCartIcon();
		
		//validate the product in cart page
		CartPage cart = new CartPage(driver);
		 String productInCart = cart.getItemName();
		
		 Assert.assertEquals(prodAdded, productInCart);
		 Assert.assertTrue(productInCart.equals(prodAdded));
		 System.out.println(productInCart);
		
		
		
		
}
}