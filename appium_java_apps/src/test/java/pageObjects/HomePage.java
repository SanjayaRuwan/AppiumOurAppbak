package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage {
	AppiumDriver<MobileElement> driver;

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
	}
	public String getHomeTitle() {
		String text = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\", \"])[2]")).getText();
		return text;
	}
	public void clickGetUserAfterLogin() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[2]")).click();
	}
	public String getGetUserAfterLogin() {
		String user=driver.findElement(By.xpath("(//android.view.View[@content-desc=\", \"])[3]")).getText();
		return user;  
	}
	public void clickChangePassword() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[3]")).click();
	}
	public String verifyGetUserAfterLoginAlert() {
		String alert=driver.findElement(By.xpath("//android.widget.TextView[@text='Logged User details success']")).getText();
		return alert;
	}
	public void clickLogot() {
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\", \"])[4]")).click();
	}
}
