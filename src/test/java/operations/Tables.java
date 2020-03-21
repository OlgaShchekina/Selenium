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

public class Tables {
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
        driver.get("http://the-internet.herokuapp.com/tables");
    }
    @AfterEach
    void tearDown() throws Exception

    {
         driver.quit();
    }
    @Test
    void test()
    {
        List<WebElement> rows = driver.findElements(By.xpath("//table[2]/tbody/tr"));
        System.out.println("Number of data rows in table 2: " + rows.size());
        for (WebElement row: rows)
            System.out.println(row.getText().split(" ")[3]);

        String cellCPath = "";
        for (int i = 1; i <= rows.size(); i++){
            cellCPath = "//table[2]/tbody/tr[" + i + "]/td[4]";
            System.out.println(driver.findElement(By.xpath(cellCPath)).getText());
        }



    }
}
