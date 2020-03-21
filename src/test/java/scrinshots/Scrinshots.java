package scrinshots;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

class Scrinshots 
{
	private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void getScreenshotOfVisibleArea() throws  IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("VisibleArea.png"));
	}
	@Test
	void getScreenshotOfEntirePage() throws  IOException 
	{
		Screenshot page = new AShot()
		.shootingStrategy(ShootingStrategies.viewportPasting(1000))
		.takeScreenshot(driver);
		ImageIO.write(page.getImage(), "png", new File("EntirePage.png"));

	}

}
