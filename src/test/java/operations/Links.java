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

public class Links {

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
        void testingLinks() throws InterruptedException {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            int numberOfLinks = links.size();
            System.out.println("The number of links:"+ numberOfLinks);
            for (WebElement link: links)
                System.out.println(link.getText() + ": " + link.getAttribute("href"));
        }
        
        @Test
        void getPageHTML()
        {
            String body = driver.getPageSource();
            System.out.println("Page HTML code:");
            System.out.println(body);
            assert(body.contains("Selenium"));
        }



    @AfterEach
        void tearDown() throws Exception

        {
           // driver.quit();
        }

    }


