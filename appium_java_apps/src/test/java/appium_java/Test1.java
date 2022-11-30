package appium_java;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.LoginPage;

public class Test1 {

	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void beforeClass() throws IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "any device name");
		cap.setCapability("appPackage", "com.appspotr.app2344221913066243299");
		cap.setCapability("appActivity", "com.appspotr.MainActivity");

		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		String sessionID = driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// ExtentTest test1 = extent.createTest("Open Application", "Open Aplication
		// Done");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots1/StartingApp.png"));
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	@Test
	public void testValidLogin() throws InterruptedException {

		LoginPage po = new LoginPage(driver);
		
		po.clickLogin();
		Thread.sleep(2000);
		po.setUsername("sanjaya@appspotr.com");
		po.setPassword("Sanjaya1");
		Thread.sleep(2000);
		

	}

}
