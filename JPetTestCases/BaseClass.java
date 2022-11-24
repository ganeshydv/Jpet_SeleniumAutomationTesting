package JPetTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

import JpetObjectRepository.Account;
import JpetObjectRepository.Cart;
import JpetObjectRepository.Catalog;
import JpetObjectRepository.FishCategory;
import JpetObjectRepository.Order;
import JpetObjectRepository.viewProduct;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	Account account;
	Cart cart;
	Catalog catalog;
	Order order;
	FishCategory fish;
	viewProduct prod;

	public BaseClass() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("select Browser: /n 1)Chrome 2)Edge");
		int choice=sc.nextInt();
		if(choice==1) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}else if(choice==2) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\GGurkhude\\Downloads\\New folder\\edgedriver_win64\\msedgedriver.exe");
	        
			 driver = new EdgeDriver();
		}
		
		catalog = new Catalog(driver);
		account=new Account(driver);
		cart=new Cart(driver);
		order=new Order(driver);
		fish=new FishCategory(driver);
		prod=new viewProduct(driver);
		
	}
	//--------------------  READ DATA FROM EXCEL SHEET  ----------------------------
	
	String readDataFromSheet(int row,int col) {
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\GGurkhude\\eclipse-workspace\\Jpet\\data\\Details.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet =workbook.getSheet("user");
			System.out.println("data "+sheet.getRow(row).getCell(col).getStringCellValue());
			return sheet.getRow(row).getCell(col).getStringCellValue();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//--------------------  SCREENSHOT METHOD  ----------------------------
	
	static int i=0;
	
	void takeScreenshot(WebDriver driver) {
		TakesScreenshot sshot=(TakesScreenshot) driver;
		File file=sshot.getScreenshotAs(OutputType.FILE);
		try
		{
			Files.copy(file,new File("C:\\Users\\GGurkhude\\eclipse-workspace\\Jpet\\ScreenShots\\screenShot"+i+".jpg"));
			System.out.println("screenshot: "+i);
			i++;
		} catch (IOException e) {
				
		}
	}

}
