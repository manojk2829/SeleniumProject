package browserLaunch;

import java.io.File;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import reportingPackage.ExtentReportingManager;

public class BaseClass {

	public WebDriver dr; 
	public WebDriverWait wait; 
	public Properties pro;
	public ExtentReports rep=ExtentReportingManager.getReporting_By_Manoj();
	public ExtentTest test;
	
	public WebDriver launchBrowser(String BrowserName) {		
		if(BrowserName.equalsIgnoreCase("chrome")) {			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			ChromeOptions ops = new ChromeOptions();
			//ops.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
			ops.setExperimentalOption("useAutomationExtension", false);
			ops.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));			
			ops.addArguments("--ignore-certificate-errors");
			ops.addArguments("--disable-notifications");			
			ops.addArguments("--disable-infobars");
			ops.addArguments("--start-maximized");
			ops.addArguments("--disable-web-security");
			//ops.addArguments("--no-proxy-server");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ops.setExperimentalOption("prefs", prefs);
			dr = new ChromeDriver(ops);
			implicitlyWait(10);
		}else if(BrowserName.equalsIgnoreCase("Firefox")) {
			//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"log\\firefox.log");
			FirefoxOptions fop=new FirefoxOptions();
			FirefoxProfile fp=new FirefoxProfile();
			fp.setPreference("dom.webnotifications.enabled", false);
			fop.setProfile(fp);
			dr=new FirefoxDriver(fop);
			implicitlyWait(10);
		}else {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			EdgeOptions edge_ops=new EdgeOptions();
			edge_ops.addArguments("--disable-notifications");
			edge_ops.addArguments("--disable-infobars");
			edge_ops.addArguments("--start-maximized");	
			edge_ops.setExperimentalOption("useAutomationExtension", false);
			edge_ops.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));			
			dr=new EdgeDriver(edge_ops);
			implicitlyWait(10);
			log_info("Browser Open Successfully....");
		}
	
		String property_data_location = System.getProperty("user.dir")+"\\src\\test\\java\\properties_File\\project.properties";
		pro=new Properties();
		try{
			FileInputStream fs = new FileInputStream(property_data_location);
			pro.load(fs);
		}catch(Exception ex) {
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getMessage());
		}
		return dr;
	}
	
	public boolean isElementPresentOnPage(String xpath) {
		int count=dr.findElements(By.xpath(xpath)).size();
		if(count==0) {
			return false;
		}if(dr.findElement(By.xpath(xpath)).isDisplayed() && dr.findElement(By.xpath(xpath)).isEnabled()) {
			return true;
		}else
		return false;
	}

	public void navigatURL(String URL) {
		dr.get(pro.getProperty(URL));
	}

	public void navigat_url_back() {
		dr.navigate().back();
	}
	
	public void wait(int sec) {
		try {
			Thread.sleep(sec*1000);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void implicitlyWait(int sec) {
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void wait_untill_element_tobe_visible(String xpath) {
	    wait = new WebDriverWait(dr,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void wait_untill_Alert_tobe_present() {
		wait = new WebDriverWait(dr,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void wait_untill_element_clickable(WebElement element) {
		wait = new WebDriverWait(dr,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void log_info(String msg) {
		test.log(Status.INFO, msg);
	}
	
	public void log_pass(String msg) {
		test.log(Status.PASS, msg);
	}
	
	public void log_skip(String msg) {
		test.log(Status.SKIP, msg);
	}
	
	public void log_fail(String msg) {
		test.log(Status.FAIL, msg);
	}
	
	
	public void quite_after_wait(int sec) {
		try {
			Thread.sleep(sec*1000);
			dr.quit();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getBrowserPageTitle() {
		System.out.println(dr.getTitle());
		log_info("Browser Page Tilte get");
	}
	
	public boolean isElementPresent_(String element) {
		WebElement e=null;
		e = dr.findElement(By.xpath(pro.getProperty(element)));
		if(e.isDisplayed()!=false) {
			System.out.println("Element is present on page and displayed successfully.");
		}else{
			System.out.println("Element is not Present on page.");
			return false;
		}
		return true;
	}
	
	public void takeScreenshot(){
		File src= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(src, new File("D:\\Lenovo\\Screen.jpg"));
			//Log Screenshot in Report
			test.log(Status.INFO, "Details of "+test.addScreenCaptureFromPath("D:\\Lenovo\\Screen.jpg"));
			           
			log_pass("Screenshot Took successfully....");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getElementScreenshot(WebElement  ele, String filePath)
    {
			// Get entire page screenshot
			File screenshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg;
			try {
			fullImg = ImageIO.read(screenshot);
			// Get the location of element on the page , 100,150
			Point point = ele.getLocation();
			
			// Get width and height of the element  -50,100
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
			   eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);
			
			// Copy the element screenshot to disk
			File screenshotLocation = new File(filePath);
			FileHandler.copy(screenshot, screenshotLocation);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}				
       
    }

}
