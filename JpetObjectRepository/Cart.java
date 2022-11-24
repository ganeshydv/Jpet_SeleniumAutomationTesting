package JpetObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	WebDriver driver;
	public Cart(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement removeItem() {
		return driver.findElement(By.xpath("//a[contains(text(),'Remove')]"));
	}
	public WebElement proceedToCheckout() {
		return driver.findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]"));
	}
	//tr
	public WebElement cartRows() {
		return driver.findElement(By.xpath("//tr"));
	}
	
	//tbody
	public WebElement cartBody() {
		return driver.findElement(By.xpath("//tbody"));
	}
	
}


