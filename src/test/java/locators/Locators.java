package locators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

class Locators {
	private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp() throws Exception {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.kmart.com");
	}
	@Test
	void test() throws InterruptedException {
		// by className 
				driver.findElement(By.className("ribbon-kmart-logo")).click();
			
		// by CSS selector - Sign In, Accounts & Points
				driver.findElement(By.cssSelector("#yourAccount")).click();	
				
				Thread.sleep(1000);
				driver.navigate().refresh();	
				
		// by id - search box
				driver.findElement(By.id("keyword")).sendKeys("milk");		

		// by link text - Kmart logo
				driver.findElement(By.linkText("Kmart home")).click();		
//				
//		// by name - search box
				driver.findElement(By.name("keyword")).sendKeys("coke");
				driver.findElement(By.id("goBtn")).click();

//		// by tagName
				System.out.println(driver.findElement(By.tagName("body")).getText());
//
//		// by XPath - Shoes
				driver.findElement(By.xpath("//a[@class='gnf_tree_junction'][contains(text(),'Shoes')]")).click();
			
	}


	@AfterEach
	void tearDown() throws Exception 
	
	{
	driver.quit();
	}
	
}
