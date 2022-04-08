package cnn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class CNN_Page extends BaseClass{
	
	@Test
	public void appTest() {
		WebDriver dr=launchBrowser("chrome");
		implicitlyWait(10);
		dr.get("https://cnn.com");
		boolean b = dr.findElement(By.xpath("//a[text()='Markets']")).isDisplayed();
		System.out.println("Market links is visible or not - " + b);
		dr.findElement(By.cssSelector("button#menuButton")).click();
		
		b = dr.findElement(By.xpath("//a[text()='Markets']")).isDisplayed();
		System.out.println("Market links is visible or not ? If Visible = true then  CLick " + b);
		dr.findElement(By.xpath("//a[text()='Markets']")).click();
	}	
	
	
	@AfterTest
	public void tearDown() {
        quite_after_wait(10);
	}
	

}
