package JPetTestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AddToCart extends BaseClass{


	public AddToCart() 
	{
		super();
	}
	//--------------------------EXTENT TEST REPORT ------------------
	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReports\\AddToCartTestCaseExtentReportResults.html");
		test = report.startTest("Add To Cart Test Case");
		
	}
	// -----------------------TEST CASES -----------------------
	@Test
	public void addItemToCartTest() 
	{
		driver.get(catalog.getHomeURL());
		
		if (driver.getTitle().equals("JPetStore Demo")) {           // Extent Report Validation
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Navigated to the specified URL Test Failed");
		}

		assertTrue(driver.getTitle().equals("JPetStore Demo"),"Home url not found");   // assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
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
		takeScreenshot(driver);                            // << --------- Screenshot BEFORE LOGIN
		
		account.login().click();
		if (catalog.welcomeContent().getText().contains("Welcome")) {   //<<-------- Extent log
			test.log(LogStatus.PASS, "Login in succesful");
		} else {
			test.log(LogStatus.FAIL, "Login in Test Failed");
		}
		assertTrue(catalog.signOut().getText().equals("Sign Out"));  // <<----- Assert validation
		
		takeScreenshot(driver);                               // << --------- Screenshot AFTER LOGIN
	
		//---------------------------- click FISH -----------------------
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);   //implict wait
		catalog.clickFish().click();
		
		if (fish.fishHeading().getText().contains("Fish")) {   //<<-------- Extent log
			test.log(LogStatus.PASS, "Click on Fish");
		} else {
			test.log(LogStatus.FAIL, "Click on Fish Test Failed");
		}
		assertTrue(fish.fishHeading().getText().contains("Fish"));  // <<----- Assert validation
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		//------------------------------- SELECT FISH1 ---------------
		
		fish.fish1().click();
		if (prod.Angelfish().getText().contains("Angelfish")) {   //<<-------- Extent log
			test.log(LogStatus.PASS, "fish1 click succesful");
		} else {
			test.log(LogStatus.FAIL, "fish1 click Test Failed");
		}
		assertTrue(prod.Angelfish().getText().contains("Angelfish"));  // <<----- Assert validation
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		//------------------------------------ Add TO CART -----------------------

		prod.addToCartFishOneOne().click();
	
		if (cart.proceedToCheckout().getText().contains("Proceed to Checkout")) {   //<<-------- Extent log
			test.log(LogStatus.PASS, "Add to cart test succesful");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		assertTrue(cart.proceedToCheckout().getText().contains("Proceed to Checkout"));  // <<----- Assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		//--------------------------------------------------------------------
		System.out.println("Add Item to Cart Test Succesful....");
		driver.quit();
	}
	
	@AfterTest
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	

}
