package productTest;
import java.io.IOException;

import org.apache.tools.ant.taskdefs.Retry;
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
public class AddProductToCartTest extends BaseClass {
@Test(groups="SmokeSutie")
public void tc_001AddProductToCart() throws IOException
{	 
	
	String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);
	
	//Navigate to Product and click on the product
	ProductPage p = new ProductPage(driver);
	String prodAdded = p.clickOnProduct(driver,PRODUCTNAME);
	
	//Add product to cart
	InventoryItemPage c = new InventoryItemPage(driver);
	c.clickOnAddToCartBtn();
	
	//Navigate to cart page
	p.clickOnCartIcon();
	
	//Validate the product in cart page
	CartPage cart = new CartPage(driver);
	String productInCart = cart.getItemName();
	
	Assert.assertEquals(prodAdded, productInCart);
	System.out.println("Assertion passed");
	System.out.println(productInCart);

	            //     OR
	
//	if(productInCart.equals(prodAdded)) {
//		System.out.println("PASS");
//		System.out.println(productInCart);
//	}
//	else
//	{
//		System.out.println("FAIL");
//	}
}	

@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
public void sampleTest()
{
	Assert.fail();
	System.out.println("Regression ");
}

}
