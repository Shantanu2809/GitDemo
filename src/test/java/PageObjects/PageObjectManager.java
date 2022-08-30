package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LandingPage lp;
	public OffersPage op;
	public CheckoutPage cp;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	public LandingPage getLandingPage()
	{
		lp = new LandingPage(driver);
		return lp;
	}
	
	public OffersPage getOffersPage()
	{
		op = new OffersPage(driver);
		return op;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		cp = new CheckoutPage(driver);
		return cp;
	}
}
