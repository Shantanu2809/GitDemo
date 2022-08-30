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
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenKartLandingPageStepDefinition {
	
	public String ParentWindow;
	public TestContextSetup tcs;
	public LandingPage lp;
	public GreenKartLandingPageStepDefinition(TestContextSetup tcs)
	{
		this.tcs=tcs;
		 lp = tcs.pom.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws Exception {
		Assert.assertTrue(lp.getTitlelandingpage().contains("GreenKart"));
	   
	   
	}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String name) throws Exception {
		
		lp.searchItem(name);
	   tcs.landingpageproductName =  lp.getproductname().split("-")[0].trim();
		System.out.println(tcs.landingpageproductName +" is extracted from home page");
	   
	    
	}
	
	@And("Added {string} items of the selected product to the cart")
	public void addproduct(String quantity) throws Exception
	{
		lp.incrementQuantity(Integer.parseInt(quantity));
		Thread.sleep(2000);
		lp.addToCart();
		Thread.sleep(2000);
	}
	
}

