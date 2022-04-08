package radioButton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import browserLaunch.BaseClass;

public class Radio_button_Class extends BaseClass{

	@Test
	public void testRadioButton() {
		launchBrowser("chrome");
		navigatURL("url_radio_button_test");
		elementToBeClickable_wait("//label[text()='Female']");
		dr.findElement(By.xpath("//label[text()='Female']")).click();
		takeScreenshot();
	}
	
	@AfterTest
	public void tearDown() {
		quite_after_wait(10);
	}
	
	public void visibility_of_element_wait(String xpath) {
		wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	
	public void elementToBeClickable_wait(String xpath) {
		wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void alert_popup_present_wait(String xpath) {
		wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
