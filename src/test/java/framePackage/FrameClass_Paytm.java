package framePackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class FrameClass_Paytm extends BaseClass{
	
	@Test
	public void frameTest() {
		  launchBrowser("chrome");
		  navigatURL("url");
		  wait_untill_element_clickable(dr.findElement(By.xpath("//div[@class='_1DP5L']")));
		  dr.findElement(By.xpath("//div[@class='_1DP5L']")).click();
		  System.out.println("Sing In button Clicking succesffully..");
		  
		  int total_frame=dr.findElements(By.tagName("iframe")).size();
		  for(int i=0;i<total_frame;i++) {
			     dr.switchTo().frame(i);
			     int a=dr.findElements(By.xpath("//p[text()='To Login into your Paytm Web account']")).size();
			     if(a==0)
			    	dr.switchTo().defaultContent(); 
			     else
			    	 break;
		  }
   
		     wait_untill_element_tobe_visible("//p[text()='To Login into your Paytm Web account']");
			 String Heading = dr.findElement(By.xpath("//p[text()='To Login into your Paytm Web account']")).getText();
			 System.out.println(Heading);
			  WebElement qrCode= dr.findElement(By.xpath("//canvas[@class='qrcode']"));
			  getElementScreenshot(qrCode, "D://Lenovo//qrCode_PayTM.png");
			  System.out.println("QR Code Screenshot Taken..");
			  dr.switchTo().defaultContent(); wait(2);
			 
		  wait_untill_element_clickable(dr.findElement(By.xpath("//*[@id='app']/header/div[2]/div[2]/div/a/img")));
		  wait(2);
		  dr.findElement(By.xpath("//*[@id='app']/header/div[2]/div[2]/div/a/img")).click();
		  wait(1);
		  dr.switchTo().defaultContent();
		  WebElement ScreenshotTarget = dr.findElement(By.xpath("//div[@class='_1kjEe']"));
		  getElementScreenshot(ScreenshotTarget, "D://Lenovo//PayTM.png");
		  dr.findElements(By.xpath("//img[@class='_1E9YT']")).get(0).click();
	}
	
	@AfterTest
	public void tearDown() {
	    quite_after_wait(10);
	}
	
	public int checkFrame_Count(WebElement e) {
		  int total_frame=dr.findElements(By.tagName("iframe")).size();
		  for(int i=0;i<total_frame;i++) {
			     dr.switchTo().frame(i);
			     int a=dr.findElements(By.xpath("//p[text()='To Login into your Paytm Web account']")).size();
			     if(a==0)
			    	dr.switchTo().defaultContent(); 
			     else
			    	 break;
		  }
		return total_frame;
	}

}
