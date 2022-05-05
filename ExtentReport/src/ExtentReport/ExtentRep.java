package ExtentReport;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentRep {

	WebDriver wb;
		@BeforeTest
		public void BT()
		{
		
		
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		//WebDriverManager.chrome.driver.setup();
		WebDriver wb= new ChromeDriver();
		ExtentReports extent;
		ExtentTest logger;
		extent = new ExtentReports(System.getProperty("user.dir")+"//Test_Output//Aishwarya.html",true);
		
		//this is used to load the configuration of file.
		extent.loadConfig(new File(System.getProperty("user.dir")+"src//ExtentReport//extent-config.xml"));
		
		
		
		
		@Test
		public void testcase1() throws InterruptedException {
			
			
			logger = extent.startTest("OrangeHRM");
			
			wb.get("https://opensource-demo.orangehrmlive.com/");	
			logger.log(LogStatus.PASS, "WebPage Opened");
			String Title = wb.getTitle();
			logger.log(LogStatus.PASS, Title);
			
			wb.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");  //gives the username
			logger.log(LogStatus.PASS, "USername enetred");
			
			wb.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123"); //gives the password
			
			wb.findElement(By.xpath("//*[@id='btnLogin']")).click(); //clicks on the login button
			logger.log(LogStatus.PASS, "Logged In Succesfully");
			Thread.sleep(3000); //sleep time duration
			extent.endTest(logger);
			extent.flush();
			extent.close();
		}
	}}









