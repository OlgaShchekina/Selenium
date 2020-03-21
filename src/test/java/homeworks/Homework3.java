package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Homework3 {
	private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://duckduckgo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test
	void test() throws InterruptedException, IOException {
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("maven");
  		driver.findElement(By.id("search_button_homepage")).click();

  		WebElement textbox =  driver.findElement(By.id("search_form_input"));
		String text = textbox.getAttribute("value");
		assertEquals("maven", text);
		//get link text
		//number of links
		assetTrue(driver.findElements(By.linkText("Apache Maven")).size()!=0);

		List<WebElement> links = driver.findElements(By.linkText("Apache Maven"));
		int numberOfLinks = links.size();

		System.out.println("The number of links:"+ numberOfLinks);
		for (WebElement link: links)
			System.out.println(link.getText() + ": " + link.getAttribute("href"));
		}

	private void assetTrue(boolean apache_maven) {
	}

	private void assertEquals(String maven, String text) {
	}

	@AfterEach
	void tearDown() throws Exception

	{
		//driver.quit();
	}

}
