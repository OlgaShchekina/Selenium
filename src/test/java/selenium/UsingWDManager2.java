package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class UsingWDManager2 
{
	private WebDriver driver;
	
	private static String browser;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
	
	Properties prop = new Properties();
	prop.load(new FileInputStream("browser.config"));
	browser = prop.getProperty("browser");
	System.out.println("Browser name is: " + browser);
}
	
	@BeforeEach
	void setUp()
	{
		switch(browser)
		{
		case "chrome" -> 
			{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		case "firefox" ->
			{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
				
		}
			
		}
	
	@Test
	void testChrome() 
	{
		
		driver.get("https://www.amazon.com");
	}


	@AfterEach
	void tearDown() throws Exception 
	
	{
		driver.quit();
	}

	
	
}
