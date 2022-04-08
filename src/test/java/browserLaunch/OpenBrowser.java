package browserLaunch;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class OpenBrowser extends BaseClass{

	@Test
	public void testCase_1() {
		
		WebDriver dr = launchBrowser("chrome");
		
		dr.get("https://cams.boutiqaat.com/login");
		implicitlyWait(19);
		dr.findElement(By.name("userName")).sendKeys("manoj");
		dr.findElement(By.name("password")).sendKeys("Manoj@1234");
		//driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		dr.findElement(By.xpath("//input[@type='submit']")).click();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(dr,10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='manoj_req']")));
		ele.click();
		//wait.until(ExpectedConditions.ele)
		ele.sendKeys(Keys.ENTER);
	}

	@AfterTest
	public void QuiteBrowser() {
         quite_after_wait(10);
	}


}
