package operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementExistance {
    private WebDriver driver;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.kmart.com/");
    }
    @AfterEach
    void tearDown() throws Exception

    {
        driver.quit();
    }

    @Test
    void verifyExistance() 
    {
        List<WebElement> list = driver.findElements(By.id("Vladimir"));
        assertTrue(list.size() == 0);
    }

    private void assertTrue(boolean b) {
    }
    @Test
    void scrollingVertically() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver; //casting
        js.executeScript("window.scroll(0, 5000)");
        Thread.sleep(5000);
    }




}
