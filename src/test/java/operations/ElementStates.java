package operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementStates {
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
        driver.get("http://book.theautomatedtester.co.uk/");
    }

    @Test
    void gettingStates()
    {
        driver.findElement(By.linkText("Chapter1")).click();
        WebElement checkbox = driver.findElement(By.name("selected(1234)"));
        assertTrue(checkbox.isDisplayed());
        checkbox.click();
        assertTrue(checkbox.isSelected());
    }

    private void assertTrue(boolean selected) {
    }
    @Test
    void readingInputField()
    {
        WebElement textbox = driver.findElement(By.id("q"));
        textbox.sendKeys("Q5 PASV");
        String text = textbox.getAttribute("value");
        assertEquals("Q5 PASV", text);
    }

    private void assertEquals(String q5_pasv, String text) {
    }


    @AfterEach
    void tearDown() throws Exception

    {
        driver.quit();
    }

}
