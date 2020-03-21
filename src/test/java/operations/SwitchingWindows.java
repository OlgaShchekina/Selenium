package operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchingWindows {
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
        driver.get("http://the-internet.herokuapp.com/windows");
    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void test() {
        String firstTab = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        String secondTab = "";

        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows)
            if(!handle.equals(firstTab))
        secondTab = handle;

        driver.switchTo().window(secondTab);
        String secondTitle = "New Window";
        assertEquals(secondTitle, driver.getTitle());

        driver.switchTo().window(firstTab);
        driver.close();

}

    private void assertEquals(String secondTitle, String title) {
    }

}
