package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class UsingWDManager 
{
	private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
{
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		driver.quit();
	}

	@Test
	void test() {
		driver.get("https://www.selenium.dev/");
	}

}
