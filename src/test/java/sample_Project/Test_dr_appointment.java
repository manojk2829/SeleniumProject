package sample_Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class Test_dr_appointment extends BaseClass{

	@Test
	public void first_Test() {	
		test= rep.createTest("Test Ready to start....");
		launchBrowser("chrome");
		dr.get(pro.getProperty("url"));
		wait(2);
		dr.findElement(By.xpath(pro.getProperty("doctor_name_xpath"))).click();
		//dr.findElement(By.xpath("//div[@class='close close1 sprite-4th-march clo-btn-ste']")).click();
		//String headerName = dr.findElement(By.xpath("//p[text()='Select Service']")).getText();
		//System.out.println(headerName);
		//dr.findElement(By.xpath(pro.getProperty("appointment_button"))).click();
		wait(2);
		isElementPresent_("name_element");
		log_pass("Element Present on Page....");
		dr.findElement(By.id(pro.getProperty("member_name"))).sendKeys("Manoj");
		dr.findElement(By.id(pro.getProperty("member_email"))).sendKeys("Manoj@gmail.com");
		dr.findElement(By.id(pro.getProperty("member_phone"))).sendKeys("93112455");
		WebElement we = dr.findElement(By.id(pro.getProperty("select_gender")));
		Select s = new Select(we);
		s.selectByVisibleText("Female");		
		dr.findElement(By.xpath(pro.getProperty("register_with_sakra"))).click();
		log_pass("Pacient already member of the hospital....");
		dr.findElement(By.name(pro.getProperty("member_uhid"))).sendKeys("123123");

		we = dr.findElement(By.xpath(pro.getProperty("member_time")));
		s=new Select(we);
		s.selectByVisibleText("13");
		log_pass("Time Drop down selected....");
		we = dr.findElement(By.id("pre_mts1"));
		s=new Select(we);
		s.selectByVisibleText("45");	

		// Date of Birth Selection logic

		dr.findElement(By.xpath(pro.getProperty("dob_select"))).click();
		String date_to_displayed = dr.findElement(By.xpath(pro.getProperty("dateDisplayed_on_click"))).getText();
		System.out.println(date_to_displayed);

		//Select date -29-04-1987

		String dob = pro.getProperty("dob_date");
		System.out.println(dob);

		//Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date_picked = sd.parse(dob);
			String day= new SimpleDateFormat("dd").format(date_picked);
			System.out.println(day);
			String month= new SimpleDateFormat("MMMM").format(date_picked);
			System.out.println(month);
			String year= new SimpleDateFormat("yyyy").format(date_picked);
			System.out.println(year);

			String monthYearToBeSelected = month+"  "+year;
			System.out.println(monthYearToBeSelected);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	@AfterTest
	public void down() {
		quite_after_wait(10);
		rep.flush();
	}

}
