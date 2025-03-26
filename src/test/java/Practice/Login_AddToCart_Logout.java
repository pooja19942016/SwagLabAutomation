package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_AddToCart_Logout {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
	driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
	WebElement ele = driver.findElement(By.xpath("//div[text()=\"Sauce Labs Fleece Jacket\"]"));
	System.out.println(ele.isDisplayed());
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.id("logout_sidebar_link")).click();
	driver.close();
}
}
