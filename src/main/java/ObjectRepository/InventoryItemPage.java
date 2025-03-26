package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class InventoryItemPage  {
	@FindBy(id="add-to-cart")
	private WebElement addToCartBtn;
	
	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	//Business library
	/**
     * This method will click on add to cart button
     */
	public void clickOnAddToCartBtn()
	{
		addToCartBtn.click();
	}
}
