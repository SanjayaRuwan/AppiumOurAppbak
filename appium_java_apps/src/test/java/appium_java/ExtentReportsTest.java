package appium_java;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsTest {

	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

	@BeforeSuite
	public void reportSetup() {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);

	}


	@AfterSuite
	public void reportTeardown() {
		extent.flush();

	}

}
