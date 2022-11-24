package JpetObjectRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Catalog {
	WebDriver driver=null;
	
	public Catalog(WebDriver driver){
		
		this.driver=driver;
	}
	private String homeURL="https://petstore.octoperf.com/actions/Catalog.action";
	
	public String getHomeURL() {
		return homeURL;
	}
	
	public WebElement signIn() {
		return driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
	}
	//img[@src='../images/sm_fish.gif']
	public WebElement clickFish() {
		return driver.findElement(By.xpath("//img[@src='../images/sm_fish.gif']"));
	}
	
	//a[contains(text(),'Sign Out')]
	public WebElement signOut() {
		return driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
	}
	
	//div[@id='WelcomeContent']
	public WebElement welcomeContent() {
		return driver.findElement(By.xpath("//div[@id='WelcomeContent']"));
	}
}




