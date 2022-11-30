package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignupPage {

	AppiumDriver<MobileElement> driver;


	public SignupPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	public void setUsername(String username) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys(username);
	}
	public void setEmail(String email) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys(email);
	}
	public void setPassword(String password) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[7]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[7]")).sendKeys(password);
	}
	public void clickSignup() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[1]")).click();
	}
	public void clickLogin() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
	}
	public String verifySignupAlert() {
		String alertsignup=driver.findElement(By.xpath("//android.widget.TextView[@text='Signup Successfully']")).getText();
		return alertsignup;
	}
	public String verifyLoginAlert() {
		String alertLogin=driver.findElement(By.xpath("//android.widget.TextView[@text='Login Success']")).getText();
		return alertLogin;
	}

}
