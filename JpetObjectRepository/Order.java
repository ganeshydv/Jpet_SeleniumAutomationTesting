package JpetObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Order {
	WebDriver driver;
	public Order(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement Continue() {
		return driver.findElement(By.xpath("//input[@name='newOrder']"));
	}
	public WebElement confirm() {
		return driver.findElement(By.xpath("(//a[contains(text(),'Confirm')])[1]"));
	}
	//li[contains(text(),'Thank you, your order has been submitted.')]
	public WebElement message() {
		return driver.findElement(By.xpath("//li[contains(text(),'Thank you, your order has been submitted.')]"));
	}
	//th[contains(text(),'Payment Details')]
	public WebElement paymentDetails() {
		return driver.findElement(By.xpath("//th[contains(text(),'Payment Details')]"));
	}
	//th[contains(.,'Shipping Address')]
	public WebElement shippingAddress() {
		return driver.findElement(By.xpath("//th[contains(.,'Shipping Address')]"));
	}
	
	//li[contains(text(),'Thank you, your order has been submitted.')]
	public WebElement orderd() {
		return driver.findElement(By.xpath("//li[contains(text(),'Thank you, your order has been submitted.')]"));
	}
}
