package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ResetPasswordPage {
	AppiumDriver<MobileElement> driver;

	public ResetPasswordPage(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public String verifyResetText() {
		String reset = driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[1]")).getText();
		return reset;
	}
	public void setEmail(String email) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys(email);
	}
	public void clickResetPassword() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
	}
	public String verifyResetPwAlert() {
		String alertReset=driver.findElement(By.xpath("//android.widget.TextView[@text='Sent mail..! Check your inbox']")).getText();
		return alertReset;
	}
}
