package testCases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;
import pageObjects.SignupPage;

public class BasicTest {

	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "any device name");
		cap.setCapability("noReset", "true");
		//cap.setCapability("fastReset", "true");
		cap.setCapability("appPackage", "com.appspotr.app2344221913066243299");
		cap.setCapability("appActivity", "com.appspotr.MainActivity");

		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		String sessionID = driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// ExtentTest test1 = extent.createTest("Open Application","Open Aplication Done");
		Thread.sleep(3000);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots1/StartingApp.png"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//(enabled=false)
	@Test (priority = 0)
	public void testValidSignup() throws InterruptedException {
		
		SignupPage signup = new SignupPage(driver);
		HomePage home = new HomePage(driver);
		
		Thread.sleep(2000);
		signup.setUsername("OZOZ");
		signup.setEmail("OZZOOZOZOZOZOZ@gmail.com");
		signup.setPassword("ZZZZ");
		Thread.sleep(2000);
		signup.clickSignup();
		Thread.sleep(2000);
		//String acAlert=signup.verifySignupAlert();
		//String exAlert = "Signup Successfully";
		//Assert.assertEquals(acAlert, exAlert);
		String acTitle = home.getHomeTitle();
		String exTitle = "Hi welcome ";
		Assert.assertTrue(acTitle.contains(exTitle));
		Thread.sleep(2000);
		home.clickLogot();
	}

	@Test(priority = 2)
	public void testValidLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);

		Thread.sleep(2000);
		login.setUsername("sanjaya@appspotr.com");
		login.setPassword("Sanjaya17");
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(1000);
		String acAlert=login.verifyLoginAlert();
		String exAlert = "Login Success";
		Assert.assertEquals(acAlert, exAlert);
		String acTitle = home.getHomeTitle();
		String exTitle = "Hi welcome ";
		Assert.assertEquals(acTitle, exTitle);
		Thread.sleep(2000);
		home.clickLogot();
		Thread.sleep(5000);
		
	}
	@Test (priority = 1)
	public void testGetUserBeforeLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		SignupPage signup = new SignupPage(driver);
		HomePage home = new HomePage(driver);
		
		Thread.sleep(2000);
		signup.clickLogin();
		Thread.sleep(2000);
		login.clickGetUserBeforeLogin();
		Thread.sleep(2000);
		String acGetUser=login.getGetUserBeforeLogin();
		String exGetUser = "@anon.appspotr.app";
		Assert.assertTrue(acGetUser.endsWith(exGetUser));
		Thread.sleep(1000);
		String acAlert=login.verifyGetUserBeforeLoginAlert();
		String exAlert = "Get user success";
		Assert.assertEquals(acAlert, exAlert);
		
	}
	@Test(priority = 3)
	public void testGetUserAfterLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);


		login.setUsername("sanjaya@appspotr.com");
		Thread.sleep(2000);
		login.setPassword("Sanjaya17");
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(4000);
		home.clickGetUserAfterLogin();
		Thread.sleep(2000);
		String acGetUser=home.getGetUserAfterLogin();
		String exGetUser = "Logged user : sanjaya@appspotr.com";
		Thread.sleep(1000);
		Assert.assertEquals(acGetUser, exGetUser);
		String acAlert=home.verifyGetUserAfterLoginAlert();
		String exAlert = "Logged User details success";
		Assert.assertEquals(acAlert, exAlert);
		Thread.sleep(2000);
		home.clickLogot();
		Thread.sleep(5000);
	}
	
	@Test (priority = 4)
	public void testResetPassword() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		ResetPasswordPage reset = new ResetPasswordPage(driver);

        
		login.clickResetPassword();
		Thread.sleep(2000);
		String acResetText=reset.verifyResetText();
		String exReset = "Reset Password";
		Assert.assertEquals(acResetText, exReset);
		reset.setEmail("sanjaya@appspotr.com");
		reset.clickResetPassword();
		Thread.sleep(1000);
		String acAlert=reset.verifyResetPwAlert();
		String exAlert = "Sent mail..! Check your inbox";
		Assert.assertEquals(acAlert, exAlert);
		Thread.sleep(2000);
		
	}
	//Changed Password successfully
	@Test (priority = 5)
	public void testChangePassword() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		ChangePasswordPage change = new ChangePasswordPage(driver);
		SignupPage signup = new SignupPage(driver);
		
		login.setUsername("sanjaya@appspotr.com");
		Thread.sleep(2000);
		login.setPassword("Sanjaya17");
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(2000);
		home.clickChangePassword();
		Thread.sleep(2000);
		change.setOldPassword("Sanjaya17");
		Thread.sleep(2000);
		change.setNewPassword("Sanjaya18");
		Thread.sleep(4000);
		change.clickChangePassword();
		Thread.sleep(2000);
		signup.clickLogin();
		Thread.sleep(2000);
		login.setUsername("sanjaya@appspotr.com");
		Thread.sleep(2000);
		login.setPassword("Sanjaya18");
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(2000);
		home.clickLogot();
		
	}

}
