package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenKartCheckOutPageStepDefinition {
	
	public String ParentWindow;
	public TestContextSetup tcs;
	public String checkoutpageproductname;
	public CheckoutPage cp;
	public GreenKartCheckOutPageStepDefinition(TestContextSetup tcs)
	{
		this.tcs=tcs;
		 cp = tcs.pom.getCheckoutPage();
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void checkoutpage(String name) throws Exception
	{
		LandingPage lp = tcs.pom.getLandingPage();
		lp.proceedtocheckoutpage();
		checkoutpageproductname = cp.getProductName().split("-")[0].trim();
		Assert.assertEquals(checkoutpageproductname, tcs.landingpageproductName);
	}
	
	@And("verify user has ability to enter promo code and place the order")
	public void verify_checkout_page() throws Exception
	{
		
		
		Assert.assertTrue(cp.VerifyPromoButton());
		Assert.assertTrue(cp.VerifyPlaceOrderButton());
		Thread.sleep(2000);
		
		
		
		
	}
}

