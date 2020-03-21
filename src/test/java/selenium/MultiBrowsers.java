package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class MultiBrowsers 
{
	private static String browser;
	private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
	
	Properties prop = new Properties();
	prop.load(new FileInputStream("browser.config"));
	browser = prop.getProperty("browser");
	System.out.println("Browser name is: " + browser);
}
	@BeforeEach
	void setUp() throws Exception 
	{
		switch(browser)
		{
		case "chrome" ->
		{System.setProperty("webdriver.chrome.driver", "/Users/olgashchekina/drivers/chromedriver");
		driver = new ChromeDriver();}
		
		case "firefox" ->
		{System.setProperty("webdriver.gecko.driver", "/Users/olgashchekina/drivers/geckodriver");
		driver = new FirefoxDriver();}
				
		}
	}
	@Test
	void test() {
		driver.get("https://www.seleniumhq.org/");
		System.out.println("Title of the page: " + driver.getTitle());
	}
	

	@AfterEach
	void tearDown() throws Exception 
	{
		driver.quit();
	}

	

}
