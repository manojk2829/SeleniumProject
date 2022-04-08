package temp;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestClass{
	public WebDriver dr;
	@Test
 	public void main() {
 		WebDriver dr=new ChromeDriver();
 		dr.navigate().to("https://www.naukri.com/");
 		//dr.navigate().refresh();
 		System.out.println(dr.getTitle());
 		
 		
 		String parent =dr.getWindowHandle();
 		Set<String> allwin=dr.getWindowHandles();
 		System.out.println(allwin.size());

 		for(String child:allwin){
 		  if(!parent.equals(child)){
 		     dr.switchTo().window(child);
 			 dr.close();
 		  }
 		}
 		
 		dr.switchTo().window(parent);
  	}
	
	@AfterTest
	public void tearDown() {
	     try{
	    	 Thread.sleep(2000);	
	     }catch(Exception ex) {
	    	 System.out.println(ex.getMessage());
	     }     
	     dr.quit();
	}
}
