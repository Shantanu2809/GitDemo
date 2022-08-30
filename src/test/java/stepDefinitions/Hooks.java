package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	public TestContextSetup tcs;
	public Hooks(TestContextSetup tcs)
	{
		this.tcs = tcs;
	}
	
	@After
	public void AfterScenario() throws Exception
	{
		tcs.testbase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws Exception
	{
		WebDriver driver = tcs.testbase.WebDriverManager();
		if (scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File from = ts.getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(from);
			scenario.attach(fileContent, "image/png", "image");
			
			//FileHandler.copy(from, new File("D:\\Users\\Temp\\Desktop\\CucumberMiniProjectFramework\\target\\test-output\\SparkReport\\screenshots"+ scenario.getName()+".png"));
			
		}
	}

}
