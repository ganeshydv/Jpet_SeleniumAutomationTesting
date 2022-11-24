package JpetObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FishCategory{
	WebDriver driver;
	public FishCategory(WebDriver driver) {
		 this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	//h2[contains(text(),'Fish')]
	public WebElement fishHeading() {
		return driver.findElement(By.xpath("//h2[contains(text(),'Fish')]"));
	}
	
	//a[contains(text(),'FI-SW-01')]
	public WebElement fish1() {
		return driver.findElement(By.xpath("//a[contains(text(),'FI-SW-01')]"));
	}
	
	public WebElement fish2() {
		return driver.findElement(By.xpath("//a[contains(text(),'FI-SW-02')]"));
	}
	
	
}
