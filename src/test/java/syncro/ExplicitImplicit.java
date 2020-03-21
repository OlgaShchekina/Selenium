package syncro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitImplicit {
    private WebDriver driver;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

    }
    @Test
    void test() {
        driver.findElement(By.id("start")).click();
//        WebElement helloWorld = new WebDriverWait(driver,15)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        WebElement helloWorld = driver.findElement(By.id("finish"));
        assertEqual ("Hello World!", helloWorld.getText());

    }

    private void assertEqual(String s, String text) {
    }

    @AfterEach
    void tearDown() throws Exception

    {
        driver.quit();
    }
}
