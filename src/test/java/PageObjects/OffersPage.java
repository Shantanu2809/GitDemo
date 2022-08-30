package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffersPage {
	public WebDriver driver;
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	
	private By offersearch =By.id("search-field");
	private By offerproductname = By.cssSelector("tr td:nth-child(1)");
	
	public void searchitem(String name) throws Exception
	{
		 driver.findElement(offersearch).click();
		Thread.sleep(2000);
		driver.findElement(offersearch).sendKeys(name);
		Thread.sleep(3000);
	}
	public String getProductName()
	{
		return driver.findElement(offerproductname).getText();
	}
	
	
}
