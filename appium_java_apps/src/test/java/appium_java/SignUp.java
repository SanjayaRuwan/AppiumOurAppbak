package appium_java;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignUp extends ExtentReportsTest {

	static AppiumDriver<MobileElement> driver;
	
	@Test
	public void basicApp() throws Exception {
		
		ExtentTest test1=extent.createTest("Test one", "Sample test demo");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName","Pixel 5a");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.appspotr.app2344221913066243299");
		cap.setCapability("appActivity", "com.appspotr.MainActivity");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		Thread.sleep(2000);
		System.out.println("Open Application Done"); 
		Thread.sleep(3000);
		
		//Verify Sign Up
		
		//Enter username
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys("Sanjaya");
		System.out.println("Entered username");
		Thread.sleep(2000);
		
		//Enter email
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys("sanjaya+1@appspotr.com");
		System.out.println("Entered email");
		Thread.sleep(2000);
		
		//Enter password
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[7]")).sendKeys("Sanj");
		System.out.println("Entered password");
		Thread.sleep(2000);

		//Click Sign up button        
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[1]/android.widget.TextView")).click();
		Thread.sleep(2000);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/SignUp.png"));
		
		//Verify home page
		String achi=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\", \"])[2]")).getText();
		String exhi="Hi welcome";
		Assert.assertTrue(achi.contains(exhi));
		System.out.println("Thanks Alert: "+achi);
		Thread.sleep(2000);
		
		//Click logout button        
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[4]")).click();
		Thread.sleep(2000);
		
		
			
	}
}
