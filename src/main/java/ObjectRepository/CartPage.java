package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(className = "inventory_item_name")
    private WebElement ItemInfo;
	
	@FindBy(xpath = "//button[.='Remove']")
	private WebElement RemoveBtn;

	public CartPage(WebDriver dirver) {
		PageFactory.initElements(dirver, this);
	}

	public WebElement getItemInfo() {
		return ItemInfo;
	}

	public WebElement getRemoveBtn() {
		return RemoveBtn;
	}
	
	//Business library
	/**
     * This method will capture the item name and return it to caller
     * @return
     */
	public String getItemName()
	{
	return	ItemInfo.getText();
	}
	
	public void ClickOnRemoveBtn() {
		RemoveBtn.click();
	}
}
