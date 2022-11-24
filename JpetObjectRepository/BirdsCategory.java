package JpetObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BirdsCategory{
	WebDriver driver;
	 public BirdsCategory(WebDriver driver) {
		 this.driver=driver;
		
		// TODO Auto-generated constructor stub
	}
	
	public WebElement bird1() {
		return driver.findElement(By.xpath("//a[contains(text(),'AV-CB-01')]"));
	}
	
	public WebElement bird2() {
		return driver.findElement(By.xpath("//a[contains(text(),'AV-SB-02')]"));
	}
}