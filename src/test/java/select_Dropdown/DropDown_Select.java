package select_Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class DropDown_Select extends BaseClass {
	public WebDriver dr;

	@Test
	public void findelements() {
		dr = launchBrowser("chrome");
		dr.get("https://www.qtpselenium.com/");
		dr.findElement(By.xpath("//a[text()='Contact Us']")).click();
		WebElement DropDownValues = dr.findElement(By.id("userCountry"));
		Select s = new Select(DropDownValues);
		List<WebElement> ele = dr.findElements(By.xpath("//*[@id='userCountry']"));
		System.out.println(ele.size());
		for(int i=0;i<ele.size();i++) {
			System.out.println(ele.get(i).getText());
			System.out.println();
		}
		s.selectByIndex(7);
		DropDownValues =s.getFirstSelectedOption();
		System.out.println(DropDownValues.getText());



	}

	@AfterTest
	public void tearDown() {
		quite_after_wait(19);
	}

}
