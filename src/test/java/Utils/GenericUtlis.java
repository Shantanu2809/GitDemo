package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtlis {
	public WebDriver driver;
	public String ParentWindow;
	
	public GenericUtlis(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void SwitchMainWindowToChild()
	{	
		if (driver.getCurrentUrl().equalsIgnoreCase("QAurl"));
		{
		String MainWindowHandle = driver.getWindowHandle();
		   Set<String> awhs  = driver.getWindowHandles();
		   Iterator<String> i1 = awhs.iterator();
		  
			 ParentWindow = i1.next();
			String ChildWindow = i1.next();
			
			driver.switchTo().window(ChildWindow);
		}
	}
	
	public void SwitchChildWindowToMain()
	{
		driver.switchTo().window(ParentWindow);
	}

}
