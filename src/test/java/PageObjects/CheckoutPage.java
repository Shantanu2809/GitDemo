package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	private By promoButton = By.xpath("//button[@class='promoBtn']");
	private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	private By checkoutproductname = By.xpath("//p[@class='product-name']");
	
	public Boolean VerifyPromoButton()
	{
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrderButton()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getProductName()
	{
		return driver.findElement(checkoutproductname).getText();
	}
	}
