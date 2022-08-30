package Utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingpageproductName;
	public PageObjectManager pom;
	public TestBase testbase;
	public GenericUtlis genericutlis;
	public TestContextSetup() throws Exception
	{
		testbase = new TestBase();
		pom = new PageObjectManager(testbase.WebDriverManager());
		genericutlis = new GenericUtlis(testbase.WebDriverManager());
		
	}
}
