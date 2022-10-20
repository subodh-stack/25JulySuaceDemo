package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.ExtentReport;
import utility.SwagLabPageElement;

@Listeners(utility.Listeners.class)
public class SwagLabLoginPageTest extends SwagLabPageElement {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports =ExtentReport.getReports();
	}
	
	@BeforeMethod
	public void launchApllication() {
		driver =Browser.openChromeBrowser();
	}
	
	@Test
	public void SwagLabLoginTest() throws EncryptedDocumentException, IOException {
		test = reports.createTest("SwagLabLoginTest");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserId(0, 0);
		swagLabLoginPage.enterPass(1, 0);
		swagLabLoginPage.clickLogin();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}
	
	@AfterMethod
	public void addResults(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
			
	}
	
	@AfterTest
	public void flushReport() {
		reports.flush();
	
	}
	
	
}
