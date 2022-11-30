package appium_java;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasicApp extends ExtentReportsTest {

	static AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "any device name");
		cap.setCapability("appPackage", "com.appspotr.app2344221913066243299");
		cap.setCapability("appActivity", "com.appspotr.MainActivity");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		String sessionID =  driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ExtentTest test1 = extent.createTest("Open Application", "Open Aplication Done");
		

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots1/StartingApp.png"));
	}
		
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	@Test
	public void validLogin() throws Exception {

		// Verify Login, Logged user and logout

		// Click login button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(2000);
		extent.createTest("Click login", "Click login succssfully.");

		// Enter email
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys("sanjaya@appspotr.com");
		extent.createTest("Enter email", "Enter email succssfully.");

		// Enter password
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys("Sanjaya1");
		extent.createTest("Enter password", "Enter password succssfully.");

		// Click login button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		extent.createTest("Enter login", "Enter login succssfully.");
		Thread.sleep(2000);

		// Verify home page
		String acWelcome = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\", \"])[2]")).getText();
		String exWelcome = "Hi welcome";
		Assert.assertTrue(acWelcome.contains(exWelcome));
		Assert.assertEquals(acWelcome, exWelcome);
		extent.createTest("Verify home page", "Verify home page succssfully.");
		Thread.sleep(2000);
		
	}	
	
	@Test
	public void getUserAfterLogin() throws Exception {

		// Click get user button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(2000);

		// Verify Logged user details
		String acuserafter = driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).getText();
		String exuserafter = "sanjaya@appspotr.com";
		Assert.assertTrue(acuserafter.endsWith(exuserafter));
		System.out.println("Login page: " + acuserafter);
		Thread.sleep(2000);

		// Click logout button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[4]")).click();
		Thread.sleep(2000);
      
		// Verify login page
		String aclogin = driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[1]")).getText();
		String exlogin = "Login";
		Assert.assertTrue(aclogin.contains(exlogin));
		System.out.println("Login page: " + aclogin);
		Thread.sleep(2000);
	}
	
	// Verify Reset Password
	@Test
	public void reset() throws Exception{
		// Click reset password button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[3]")).click();
		Thread.sleep(2000);

		// Enter email
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys("sanjaya@appspotr.com");
		System.out.println("Entered email");
		Thread.sleep(2000);

		// Click reset password button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(2000);

		// Verify login page
		String acloginreset = driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[1]")).getText();
		String exloginreset = "Login";
		Assert.assertTrue(acloginreset.contains(exloginreset));
		System.out.println("Login page: " + acloginreset);
		Thread.sleep(2000);
	}
		// Verify get user before login
	public void getUserBeforeLogin() throws Exception{
		// Click get user button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[4]")).click();
		Thread.sleep(5000);

		// Verify login page
		String acuserbefore = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\", \"])[2]"))
				.getText();
		String exuserbefore = "@anon.appspotr.app";
		Assert.assertTrue(acuserbefore.endsWith(exuserbefore));
		System.out.println("Login page: " + acuserbefore);
		Thread.sleep(2000);
	}
	
		//Verify Change Password
	public void changePassword() throws Exception{	
		// Enter email
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys("sanjaya@appspotr.com");
		System.out.println("Entered email");
		Thread.sleep(2000);

		// Enter password
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys("Sanjaya");
		System.out.println("Entered password");
		Thread.sleep(2000);

		// Click login button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(2000);

		// Click change password button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[3]")).click();
		Thread.sleep(2000); 

		// Enter old password
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys("Sanjaya");
		System.out.println("Entered old pw");
		Thread.sleep(2000);

		// Enter new password
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys("Sanjaya1");
		System.out.println("Entered new pw");
		Thread.sleep(2000);

		// Click change password button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(5000);

		// Click login button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(2000); 

		// Enter email
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys("sanjaya@appspotr.com");
		System.out.println("Entered email");
		Thread.sleep(2000);

		// Enter password
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys("Sanjaya1");
		System.out.println("Entered password");
		Thread.sleep(2000);

		// Click login button
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
		Thread.sleep(2000);

		// Verify home page
		String achi2 = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\", \"])[2]")).getText();
		String exhi2 = "Hi welcome";
		Assert.assertTrue(achi2.contains(exhi2));
		System.out.println("Thanks Alert: " + achi2);
		Thread.sleep(2000);
		
	}
   
	
}
