package homeworks;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.io.FileHandler;

class Homework2 {
	private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://www.trademe.co.nz/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test
	void test() throws InterruptedException, IOException {
		driver.findElement(By.id("searchString")).sendKeys("milk");
		driver.findElement(By.cssSelector(".btn.btn-trademe")).click();
		//driver.findElement(By.className("btn")).click();
		driver.navigate().refresh();
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		TakesScreenshot ts = (TakesScreenshot)driver;
		FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("VisibleArea1.png"));
		driver.navigate().back();

		}

	@AfterEach
	void tearDown() throws Exception

	{
		driver.quit();
	}

}
