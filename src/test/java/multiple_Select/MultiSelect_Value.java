package multiple_Select;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

import browserLaunch.BaseClass;

public class MultiSelect_Value extends BaseClass {
	public WebDriver dr;

	@Test
	public void findelements() {
		dr = launchBrowser("chrome");
		dr.get("https://html.com/attributes/select-multiple/");
		System.out.println(dr.findElement(By.xpath("//div[@class='render']/p")).getText());
		System.out.println();
		
		WebElement DropDownValues = dr.findElement(By.xpath("//select"));
		Select s = new Select(DropDownValues);
		List<WebElement> ele = dr.findElements(By.xpath("//select"));
		System.out.println(ele.size());
		for(int i=0;i<ele.size();i++) {
			System.out.println(ele.get(i).getText());
			System.out.println();
		}
		s.selectByIndex(2);
		DropDownValues =s.getFirstSelectedOption();
		System.out.println(DropDownValues.getText());
		
		s.selectByVisibleText("Andean flamingo");		
		s.selectByVisibleText("James's flamingo");
		
		List <WebElement> selectText=s.getAllSelectedOptions();
		
        System.out.println(selectText.size());
        for(int i=0;i<selectText.size();i++) {
        	System.out.println(selectText.get(i).getText());
        }
        
        File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
        try{
        	FileHandler.copy(src, new File("C:\\Users\\Manoj\\eclipse-21\\SeleniumProject\\reportFiles\\test.jpg"));
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
           
        
	}

	@AfterTest
	public void tearDown() {
		quite_after_wait(19);
	}
}