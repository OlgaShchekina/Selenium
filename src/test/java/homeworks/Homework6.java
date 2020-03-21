package homeworks;

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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Homework6 {
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
    void test() throws InterruptedException {

       driver.findElement(By.linkText("Policies")).click();
        Thread.sleep(2000);

        String firstTab = driver.getWindowHandle();
        driver.findElement(By.linkText("Cars")).click();
        String secondTab = "";
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows)
            if(!handle.equals(firstTab))
                secondTab = handle;
        driver.switchTo().window(secondTab);
        String secondTitle = "Used Cars";
        assertEquals(secondTitle, driver.getTitle());
        driver.close();
    }

    private void assertEquals(String secondTitle, String title) {
    }

    @AfterEach
    void tearDown() throws Exception {
       //  driver.quit();
    }
}

