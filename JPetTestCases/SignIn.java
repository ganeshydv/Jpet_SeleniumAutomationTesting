package JPetTestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SignIn extends BaseClass{


	// --------------------------EXTENT TEST REPORT ------------------
	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReports\\SignInTestCaseExtentReportResults.html");
		test = report.startTest("SignIn Test Case");

	}
	
	@Test(priority = 1)
	public void navigateToUrl() {
		driver.get(catalog.getHomeURL());
		if (driver.getTitle().equals("JPetStore Demo")) {           // Extent Report Validation
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Navigated to the specified URL Test Failed");
		}

		assertTrue(driver.getTitle().equals("JPetStore Demo"),"Home url not found");   // assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
	}
	
	@Test(priority = 2)
	public void siginInTest() {
		
		//---------- Sign In ---------------
		catalog.signIn().click();

		if (catalog.signIn().getText().equals("Sign In")) {       //<<------ Extent Log
			test.log(LogStatus.PASS, "click on Sign In");
		} else {
			test.log(LogStatus.FAIL, "click on Sign In Test Failed");
		}

	    // assert validation
		System.out.println( catalog.signIn().getText());
		assertTrue(catalog.signIn().getText().equals("Sign In"));
		
		//------------------------LOGIN----------------------------

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		account.userName().sendKeys(readDataFromSheet(1, 1));  // <<----- reading from excel sheet
		
		account.password().clear();
		
		String s=readDataFromSheet(0, 1);                    // <<----- reading from excel sheet

		account.password().sendKeys(s.substring(0,s.length()-1));  
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		takeScreenshot(driver);                         // << --------- Screenshot BEFORE LOGIN
		
		account.login().click();
		if (catalog.welcomeContent().getText().contains("Welcome")) {   //<<-------- Extent log
			test.log(LogStatus.PASS, "Login in succesful");
		} else {
			test.log(LogStatus.FAIL, "Login in Test Failed");
		}
		assertTrue(catalog.signOut().getText().equals("Sign Out"));  // <<----- Assert validation
		
		takeScreenshot(driver);                          // << --------- Screenshot AFTER LOGIN
	System.out.println("Sign In Test Succesful.....");
	driver.quit();

	}
	
	@AfterTest
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}
