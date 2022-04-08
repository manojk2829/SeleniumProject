package takeScreenshot_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class ScreenShotClass extends BaseClass {
	
	@Test
	public void testScreenshot() {
	  launchBrowser("chrome");
	  navigatURL("url");
	  WebElement eleLocation = dr.findElement(By.xpath("//form[@class='md-float-material']"));
	  takeScreenshot();
	  getElementScreenshot(eleLocation,"D:\\Lenovo\\Screen_Element.jpg");
	  
	}

	
	@AfterTest
	public void tearDown() {
	    quite_after_wait(10);
	}

}
