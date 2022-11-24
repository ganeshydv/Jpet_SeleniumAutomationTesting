package JPetTestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OrderItem extends BaseClass {

	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(
				System.getProperty("user.dir") + "\\ExtentReports\\OrderItemTestCaseExtentReportResults.html");
		test = report.startTest("Order Item Test Case");
	}

	// -----------------------TEST CASES -----------------------
	@Test(priority = 1)
	public void openUrl() {
		driver.get(catalog.getHomeURL());
		if (driver.getTitle().equals("JPetStore Demo")) { // Extent Report Validation
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Navigated to the specified URL Test Failed");
		}

		assertTrue(driver.getTitle().equals("JPetStore Demo"), "Home url not found"); // assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
	}
	@Test(priority = 2)
	public void OrderItemTest() {
		// -----
		// ---------- Sign In ---------------
		catalog.signIn().click();

		if (catalog.signIn().getText().equals("Sign In")) { // <<------ Extent Log
			test.log(LogStatus.PASS, "click on Sign In");
		} else {
			test.log(LogStatus.FAIL, "click on Sign In Test Failed");
		}

		// assert validation
		System.out.println(catalog.signIn().getText());
		assertTrue(catalog.signIn().getText().equals("Sign In"));

		// ------------------------LOGIN----------------------------

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		account.userName().sendKeys(readDataFromSheet(1, 1)); // <<----- reading from excel sheet

		account.password().clear();

		String s = readDataFromSheet(0, 1); // <<----- reading from excel sheet

		account.password().sendKeys(s.substring(0, s.length() - 1));
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		takeScreenshot(driver); // << --------- Screenshot BEFORE LOGIN

		account.login().click();
		if (catalog.welcomeContent().getText().contains("Welcome")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "Login in succesful");
		} else {
			test.log(LogStatus.FAIL, "Login in Test Failed");
		}
		assertTrue(catalog.signOut().getText().equals("Sign Out")); // <<----- Assert validation

		takeScreenshot(driver); // << --------- Screenshot AFTER LOGIN

		// ---------------------------- click FISH -----------------------

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS); // implict wait
		catalog.clickFish().click();

		if (fish.fishHeading().getText().contains("Fish")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "Click on Fish");
		} else {
			test.log(LogStatus.FAIL, "Click on Fish Test Failed");
		}
		assertTrue(fish.fishHeading().getText().contains("Fish")); // <<----- Assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		// ------------------------------- SELECT FISH1 ---------------

		fish.fish1().click();
		if (prod.Angelfish().getText().contains("Angelfish")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "fish1 click succesful");
		} else {
			test.log(LogStatus.FAIL, "fish1 click Test Failed");
		}
		assertTrue(prod.Angelfish().getText().contains("Angelfish")); // <<----- Assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		// ------------------------------------ Add TO CART -----------------------

		prod.addToCartFishOneOne().click();

		if (cart.proceedToCheckout().getText().contains("Proceed to Checkout")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "Add to cart test succesful");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		assertTrue(cart.proceedToCheckout().getText().contains("Proceed to Checkout")); // <<----- Assert validation

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

		// ----------------------------------Checkout -ORDER
		// ------------------------------------

		cart.proceedToCheckout().click();

		if (order.paymentDetails().getText().contains("Payment Details")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "proceed to checkout succesful");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		assertTrue(order.paymentDetails().getText().contains("Payment Details")); // <<----- Assert validation

		// --------------------------------------------------------------------

		order.Continue().click();

		if (order.shippingAddress().getText().contains("Shipping Address")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "proceed to shipping address page succesful");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		assertTrue(order.shippingAddress().getText().contains("Shipping Address")); // <<----- Assert validation

		// --------------------------------------------------

		order.confirm().click();
		System.out.println("item removed succesfully...");
		if (order.orderd().getText().contains("Thank you, your order has been submitted.")) { // <<-------- Extent log
			test.log(LogStatus.PASS, "order succesful");
		} else {
			test.log(LogStatus.FAIL, "order Test Failed");
		}

		assertTrue(order.message().getText().equals("Thank you, your order has been submitted."));
		System.out.println("Order Item Test Succeful...");
		driver.quit();
	}
	
	

	@AfterTest
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}
