package pageObjects;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {

	AppiumDriver<MobileElement> driver;

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username1) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys(username1);
	}
	public void setPassword(String password1) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys(password1);
	}
	public void clickLogin() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
	}
	public void clickResetPassword() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[3]")).click();
	}
	public void clickGetUserBeforeLogin() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[4]")).click();
	}
	public String getGetUserBeforeLogin() {
		String user=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\", \"])[2]")).getText();
		return user;
	}
	public String verifyGetUserBeforeLoginAlert() {
		String alert=driver.findElement(By.xpath("//android.widget.TextView[@text='Get user success']")).getText();
		return alert;
	}
	public String verifyLoginAlert() {
		String alertLogin=driver.findElement(By.xpath("//android.widget.TextView[@text='Login Success']")).getText();
		return alertLogin;
	}

}
