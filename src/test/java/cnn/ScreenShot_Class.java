package cnn;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
public class ScreenShot_Class {
	
	    public static void main(String[] args) {
	        //set the location of chrome browser
	        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	        
	        // Initialize browser
	        WebDriver driver = new ChromeDriver();
	        
	        //navigate to url
	        driver.get("https://google.com");
	        
	       //Take the screenshot
			/*
			 * File screenshot = ((TakesScreenshot)
			 * driver).getScreenshotAs(OutputType.FILE);
			 * 
			 * //Copy the file to a location and use try catch block to handle exception try
			 * { FileHandler.copy(screenshot, new
			 * File("C:\\Users\\Manoj\\eclipse-21\\SeleniumProject\\reportFiles\\shot.png"))
			 * ; } catch (IOException e) { System.out.println(e.getMessage()); }
			 */

	        
	        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try{
	              FileHandler.copy(screenshotFile, new File("Screenshot Location C://user//manoj//Screenshot.jpg"));
	        }catch(Exception ex){
	           System.out.println(ex.getMessage());
	        }
	        driver.close();
	        WebElement src=driver.findElement(By.xpath(""));
	        WebElement destination=driver.findElement(By.xpath(""));
	        Actions act=new Actions(driver);
	        act.doubleClick().build().perform();
	        act.dragAndDrop(src,destination);
	        act.moveToElement(destination);
        
	    }
}
