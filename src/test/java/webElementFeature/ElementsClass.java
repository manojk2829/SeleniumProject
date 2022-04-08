package webElementFeature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class ElementsClass extends BaseClass {
	public WebDriver dr;

	@Test
	public void findelements() {
		dr = launchBrowser("chrome");
		dr.get("https://www.zoho.com/index1.html");

		boolean b=dr.findElement(By.
				xpath("//div[@class='signupcontainer']//a[text()='Sign up']")).isDisplayed();
		if(b==true) { dr.findElement(By.
				xpath("//div[@class='signupcontainer']//a[text()='Sign up']")).click(); 
		   }else{
			   System.out.println("Else part is getting Click .... ");
				wait(2);
				dr.findElement(By.xpath("//div[@class='signupcontainer']//a[text()='Sign up']")).click();
		   }
		        dr.findElement(By.xpath("//*[@name='email']")).sendKeys("Manojk2829"); 
		  wait(3);
		  dr.findElement(By.xpath("//*[@id='signup-termservice']")).click();
		  dr.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		  
		  System.out.println("Successfully Click Check box");
		  
		  String getErrorText = dr.findElement(By.xpath("//*[@id='emailfield-error']")).getText();
		  System.out.println(getErrorText);
		  
		  String cboxStatus  = dr.findElement(By.xpath("//*[@id='signup-termservice']")).getAttribute("checked");
		  System.out.println(cboxStatus);


	}

	@AfterTest
	public void tearDown() {
		quite_after_wait(90);
	}

}
