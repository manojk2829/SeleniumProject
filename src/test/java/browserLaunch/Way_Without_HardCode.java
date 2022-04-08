package browserLaunch;

import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Way_Without_HardCode extends BaseClass{
	
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
			int i=1;
			while(isElementPresentOnPage(p1+i+p2)){
				String text= dr.findElement(By.xpath(p1+i+p2)).getText();
				String url = dr.findElement(By.xpath(p1+i+p2)).getAttribute("href");				
				System.out.println(text + "  *******  " + url);
				boolean result = validatelinkResponse(url);
				assertion = new SoftAssert();
				assertion.assertTrue(result, "Invalid URL, Getting Wrong Status code....");
				dr.findElement(By.xpath(p1+i+p2)).click();
				System.out.println(dr.getTitle());
	     	    wait(2);
                navigat_url_back();
				wait(5);	
		    	dr.findElement(By.xpath("//a[text()='CMS']")).click();
		    	wait(1);
				System.out.println("***********************************************");	
				i++;
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
