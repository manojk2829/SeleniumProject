package javaScript_Executer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import browserLaunch.BaseClass;

public class JavaScriptClass extends BaseClass{
	
	@Test
	public void javaSriptTest() throws InterruptedException {
		test=rep.createTest("Start test....");
		launchBrowser("chrome");
		navigatURL("url");
		System.out.println(dr.getTitle());
		WebElement target= dr.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[3]/a"));
		Actions act=new Actions(dr);
		act.moveToElement(target).build().perform();
        WebElement ele = dr.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span"));
       	wait_untill_element_clickable(ele);
       	ele.click();
       	WebElement target_start_point= dr.findElement(By.xpath("//*[@id='secondary']/div[1]/div[7]/div/div/div[1]/div/div/div[1]/div"));
       	//waitForPageToLoad();
        JavascriptExecutor js=(JavascriptExecutor)dr;
		
		  int y=target_start_point.getLocation().y;
		  js.executeScript("window.scrollTo(0,"+(y-20)+")");
		  act.clickAndHold(target_start_point).moveByOffset(100, 0).release().build().perform();

	}
	
	@AfterTest
	public void tearDown() {
		rep.flush();
	    quite_after_wait(10);
	}

	public void waitForPageToLoad() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)dr;
		int i=0;
		// page to load 100% -- wait for max 20 seconds.
		while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);// complete, loading, interactive
	
			if(state.equals("complete"))
				break;
			else
				Thread.sleep(2000);	
			i++;
		}
		// check for jquery/ajax status		
		i=0;
		while(i!=10){
			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);//0,1
			if(d.longValue() == 0 )
				break;
			else
				Thread.sleep(2000);
			i++;
		}
		
	}
}
