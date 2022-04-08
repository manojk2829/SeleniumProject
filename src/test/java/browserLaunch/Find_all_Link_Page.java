package browserLaunch;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Find_all_Link_Page extends BaseClass{
    public SoftAssert assertion;	
	@Test
	public void testLink() throws IOException {
		test= rep.createTest("Test Ready to start....");		
		launchBrowser("chrome");
		navigatURL("url");
		dr.findElement(By.name("userName")).sendKeys("manoj");
		dr.findElement(By.name("password")).sendKeys("Manoj@1234");
		dr.findElement(By.name("password")).sendKeys(Keys.ENTER);
		wait(2);
		dr.findElement(By.xpath("//a[text()='CMS']")).click();
		WebElement alllink_inSide_CMS = dr.findElement(By.xpath("//div[@class='hide-child-option col-12 pt-3 CMS']"));
		List<WebElement> allLink= alllink_inSide_CMS.findElements(By.tagName("a"));
		System.out.println(allLink.size());
		
		for(int i=0;i<allLink.size();i++) {
			System.out.println(allLink.get(i).getText());
			String linkURL=allLink.get(i).getAttribute("href");
			System.out.println(linkURL);
			System.out.println("-----------------------------------------");
			boolean linkResult = validatelinkResponse(linkURL);
	    	System.out.println(linkURL + " - URL is valid.");
	    	System.out.println("-----------------------------------------");
	    	assertion = new SoftAssert();
			assertion.assertTrue(linkResult, "Invalid Response Code, not equal to 200.");
			allLink.get(i).click();
	    	wait(5);
	    	System.out.println(dr.getTitle());
	    	navigatURL("url");
	    	dr.findElement(By.xpath("//a[text()='CMS']")).click();
	    	alllink_inSide_CMS = dr.findElement(By.xpath("//div[@class='hide-child-option col-12 pt-3 CMS']"));
	    	allLink= alllink_inSide_CMS.findElements(By.tagName("a"));
	    	
		}
		System.out.println("************* Manoj Kushwaha **************");
		takeScreenshot();
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
