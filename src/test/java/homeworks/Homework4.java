package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Homework4 {
    private WebDriver driver;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/WebTable.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    void test() {

        //columnHeadings
        String columnHeadings = "";
        columnHeadings = "//*[@class='ui-grid-header ng-scope']";
        System.out.println(driver.findElement(By.xpath(columnHeadings)).getText());


//			// Last Name column
//			List<WebElement> rows = driver.findElements(By.xpath("//*[@class='ui-grid-row ng-scope']")); //length
//			//System.out.println("Number of data rows in table: " + rows.size()); // number of rows
//			String lastNameColumn = "";
//			for (int i = 0; i < rows.size(); i++) {
//				lastNameColumn = "//div[contains(@id,'-"+ i +"-uiGrid-0008-cell')]";
//				System.out.println(driver.findElement(By.xpath(lastNameColumn)).getText());
		List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']/div[4]/div"));
		for (WebElement row: rows){
			System.out.println(row.getText());
		}

        //number of cells
//			List<WebElement> cells = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
//			System.out.println("Number of cells " + cells.size());


    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }
}

