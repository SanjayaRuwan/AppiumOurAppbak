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

public class ChangedPassword extends ExtentReportsTest {

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
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/StartingApp.png"));
		
		Thread.sleep(3000);
		System.out.println("Open Application Done"); 
		Thread.sleep(5000);
		
		
		//Verify Change Password
		
				// Click logout button
				driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
				Thread.sleep(2000);
		
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
