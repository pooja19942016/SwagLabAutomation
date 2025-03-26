package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	@FindBy(id="user-name")
	private WebElement usernameEdt;

	@FindBy(id="password")
	private WebElement passwordEdt;

	@FindBy(id="login-button")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	} 

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLogin() {
		return loginBtn;
	}

	/**
	 * This method is used to login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void LoginToApp (String USERNAME,String PASSWORD)
	
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();	
	}
}


