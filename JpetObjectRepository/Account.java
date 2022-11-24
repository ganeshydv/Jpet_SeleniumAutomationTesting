package JpetObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Account {
	WebDriver driver;

	public Account(WebDriver driver) {
		this.driver = driver;
	}

	// username
	// input[@id='stripes--1056727468']
	public WebElement userName() {
		return driver.findElement(By.xpath("//input[@name='username']"));
	}

	// psd
	// input[@name='password']
	public WebElement password() {
		return driver.findElement(By.xpath("//input[@name='password']"));
	}

	// login
	// input[@name='signon']
	public WebElement login() {
		return driver.findElement(By.xpath("//input[@name='signon']"));
	}

}
