package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	private By landingsearch = By.xpath("//input[@class='search-keyword']");
	private By landingproductname = By.cssSelector("h4.product-name");
	private By topdeals = By.linkText("Top Deals");
	private By cart_icon = By.cssSelector("img[alt='Cart']");
	private By checkout = By.xpath("//button[contains(text(),'TO CHECKOUT')]");
	private By increment = By.xpath("//a[@class='increment']");
	private By addToCart = By.cssSelector(".product-action button");

	public void searchItem(String name) throws Exception
	{
		driver.findElement(landingsearch).click();
		
		   Thread.sleep(2000);
		   driver.findElement(landingsearch).sendKeys(name);
		   Thread.sleep(3000);
	}
	public String getproductname()
	{
		return driver.findElement(landingproductname).getText();
		
	}
	 public void selectTopDealsPage()
	 {
		 driver.findElement(topdeals).click();
	 }
	  
	 public void proceedtocheckoutpage() throws Exception
	 {
		 driver.findElement(cart_icon).click();
		 Thread.sleep(3000);
		 driver.findElement(checkout).click();
	 }
	 
	 public String getTitlelandingpage()
	 {
		 return driver.getTitle();
	 }
	 
	 public void incrementQuantity(int quantity) throws Exception
	 {
		 int i = quantity-1;
		 while(i>0)
		 {
			 driver.findElement(increment).click();
			 Thread.sleep(1000);
			 i--;
		 }
	 }
	 
	 public void addToCart()
	 {
		 driver.findElement(addToCart).click();
	 }
}

