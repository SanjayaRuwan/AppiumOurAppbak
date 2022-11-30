package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ChangePasswordPage {
	AppiumDriver<MobileElement> driver;

	public ChangePasswordPage(AppiumDriver driver) {
		this.driver = driver;
	}
	public void setOldPassword(String oldPassword) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).sendKeys(oldPassword);
	}
	public void setNewPassword(String newPassword) {
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).clear();
		driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[5]")).sendKeys(newPassword);
	}
	public void clickChangePassword() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
	}
	public String verifyChangePwAlert() {
		String alertReset=driver.findElement(By.xpath("//android.widget.TextView[@text='Changed Password successfully']")).getText();
		return alertReset;
	}
}
