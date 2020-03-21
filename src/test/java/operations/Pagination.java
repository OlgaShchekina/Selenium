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

public class Pagination {

    private WebDriver driver;

    @BeforeAll
    static void setUpBeforeClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/gp/goldbox");
        driver.manage().window().maximize();
    }

    @Test
    void test()
    {
        driver.findElement(By.xpath("//span[11]/div[1]/label[1]/input[1]")).click();

// Showing 1-xx of xxx results for
        String results = driver.findElement(By.cssSelector("#FilterItemView_all_summary span:nth-child(2)"))
                .getText();

        String[] resultWords = results.split(" ");
// total results matching
        int totalResults = Integer.parseInt(resultWords[3]);
        System.out.println("Total results found: " + totalResults);
// results displayed on one page
        int resultsDisplayed = Integer.parseInt(resultWords[1].split("-")[1]);
        System.out.println("Maximum results displayed on one page: " + resultsDisplayed);

// total number of pages
        int numberOfPages = (int)Math.ceil((double)totalResults/resultsDisplayed);
        System.out.println("Total number of pages: " + numberOfPages);

// calculate actual number of visible results on all pages
        int actualTotalResults = 0;
        for (int i = 1; i <= numberOfPages; i++)
        {
            List<WebElement> visibleResults =
                    driver.findElements(By.className("tallCellView"));

            actualTotalResults += visibleResults.size();
            System.out.println("Page: " + i + " visible results: " + visibleResults.size());

            if (i == numberOfPages)
                break;
            driver.findElement(By.linkText("Next→")).click();
        }
        assertEquals(totalResults, actualTotalResults);
    }

    private void assertEquals(int totalResults, int actualTotalResults) {
    }

    @AfterEach
    void tearDown()
    {
       // driver.quit();
    }
}
