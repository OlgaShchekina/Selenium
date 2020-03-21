package homeworks;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class Homework1 {
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
	}

	@Test
	void test()  {
		System.out.println("driver = " + driver);
		driver.get("https://www.trademe.co.nz/");
		driver.findElement(By.linkText("Community")).click();

		boolean staleElement = true;
		while (staleElement)
		{
			try
			{
				driver.findElement(By.linkText("Announcements")).click();
				staleElement = false;
			}
			catch (org.openqa.selenium.StaleElementReferenceException e)
			{
				if (e.getMessage().contains("element is not attached"))
					staleElement = true;
				System.out.println("Stale element");
			}
			String announcements = driver.findElement(By.className("header")).getText();
			assertEquals("Announcements",announcements);
		}

	}

	@AfterEach
	void tearDown() throws Exception 
	
	{
	driver.quit();
	}
	
}
