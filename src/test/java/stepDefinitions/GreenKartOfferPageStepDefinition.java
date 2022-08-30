package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenKartOfferPageStepDefinition {
	public String offernameprodpage;
	//public String ParentWindow;
	public TestContextSetup tcs;
	//public PageObjectManager pom;
	public GreenKartOfferPageStepDefinition(TestContextSetup tcs)
	{
		this.tcs=tcs;
	}
	
	@Then("^User searched for same shortname (.+) in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_the_product_exist(String name) throws Exception  {
	//	pom = new PageObjectManager(tcs.driver);
		OffersPage op = tcs.pom.getOffersPage();
		//OffersPage op = new OffersPage(tcs.driver);
		LandingPage lp = tcs.pom.getLandingPage();
		//LandingPage lp = new LandingPage(tcs.driver);
				lp.selectTopDealsPage();
				Thread.sleep(2000);
				switchtoofferspage();
				op.searchitem(name); 
				offernameprodpage= op.getProductName();
				Thread.sleep(3000);
				
		   
	}
	public void switchtoofferspage()
	{
		//if (tcs.testbase.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/"));
		
		tcs.genericutlis.SwitchMainWindowToChild();
		
	}
	
	public void switchtolandingpage()
	{
		tcs.genericutlis.SwitchChildWindowToMain();
	}
	
	@And("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() throws Exception {
		
	    Assert.assertEquals(offernameprodpage, tcs.landingpageproductName);
		tcs.testbase.WebDriverManager().close();
		switchtolandingpage();
		Thread.sleep(2000);
		//tcs.testbase.WebDriverManager().quit();
	}
}

