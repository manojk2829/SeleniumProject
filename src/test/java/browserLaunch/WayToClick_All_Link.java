package browserLaunch;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WayToClick_All_Link extends BaseClass{
    public SoftAssert assertion;
	@Test
	public void checkLink_Status() {
		
		test= rep.createTest("Test Ready to start....");		
		launchBrowser("chrome");
		navigatURL("url");
		dr.findElement(By.name("userName")).sendKeys("manoj");
		dr.findElement(By.name("password")).sendKeys("Manoj@1234");
		dr.findElement(By.name("password")).sendKeys(Keys.ENTER);
		wait(2);
		dr.findElement(By.xpath("//a[text()='CMS']")).click();
		String p1="/html/body/div[1]/div/div[1]/div[1]/div[2]/ul/li[2]/div/ul/li[";
		String p2="]/a";
		for(int i=1;i<=9;i++) {
			String text= dr.findElement(By.xpath(p1+i+p2)).getText();
			String url = dr.findElement(By.xpath(p1+i+p2)).getAttribute("href");
			
			System.out.println(text + "  *******  " + url);
			
			boolean result = validatelinkResponse(url);
			assertion = new SoftAssert();
			assertion.assertTrue(result, "Invalid URL, Getting Wrong Status code....");
			dr.findElement(By.xpath(p1+i+p2)).click();
			System.out.println(dr.getTitle());
     	    wait(5);
	    	navigatURL("url");	
			wait(5);	
	    	dr.findElement(By.xpath("//a[text()='CMS']")).click();
	    	wait(2);
			System.out.println("***********************************************");
	    		
	}
}
	
	public boolean validatelinkResponse(String url){
		int resp_code=0;
		try{
			HttpURLConnection c= (HttpURLConnection)new URL(url).openConnection();
			      c.setRequestMethod("HEAD");
			      c.connect();
			      resp_code = c.getResponseCode();
			      //System.out.println("Http response code: " + resp_code);
			      if(resp_code ==200)
			    	  System.out.println("Reposne code getting 200 OK. -- ULR Pass.");
			    	  return true;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
     }
		
	
	@AfterTest
	public void tearDown() {
		
	    rep.flush();		
	    quite_after_wait(10);
	    assertion.assertAll();	

	}
}
