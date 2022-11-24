package JpetObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class viewProduct{
	WebDriver driver;
	public viewProduct(WebDriver driver) {
		this.driver=driver;
	}
	
	//a[contains(text(),'Add to Cart')]
	public WebElement addToCartFishOneOne() {
		return driver.findElement(By.xpath("(//a[contains(text(),'Add to Cart')])[1]"));
	}
	
	//h2[contains(text(),'Angelfish')]
	public WebElement Angelfish() {
		return driver.findElement(By.xpath("//h2[contains(text(),'Angelfish')]"));
	}
}