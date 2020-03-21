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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

class Homework5 {
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
    void test() {
        driver.findElement(By.id("SiteHeader_Sitenav_servicesLinkListItem")).click();

        WebElement  surveyDialog = driver.findElement(By.xpath("//*[contains(text(),'No thanks')]"));
        if (surveyDialog.isDisplayed())
            surveyDialog.click();

        WebElement dropdown = driver.findElement(By.id("134"));
        Select s = new Select(dropdown);
        s.selectByVisibleText("Auckland");

        WebElement dropdown1 = driver.findElement(By.id("135"));
        Select s1 = new Select(dropdown1);
        s1.selectByVisibleText("All districts");

        WebElement dropdown2 = driver.findElement(By.id("193"));
        Select s2 = new Select(dropdown2);
        s2.selectByVisibleText("Events & entertainment");

        WebElement dropdown3 = driver.findElement(By.id("209"));
        Select s3 = new Select(dropdown3);
        s3.selectByVisibleText("Photography & video");

        driver.findElement(By.id("sidebar-153")).sendKeys("wedding");
        driver.findElement(By.xpath("//button[contains(@class,'button27 ')]")).click();

        // number of links, text and href
        List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='supergrid-bucket largelist ']"));
        int allNumberOfLinks = allLinks.size();
        System.out.println("The number of links:" + allNumberOfLinks);

        List<WebElement> links = driver.findElements(By.partialLinkText("Wedding"));
        int numberOfLinks = links.size();
        System.out.println("The number of links:" + numberOfLinks);

        for (WebElement link : links)
            System.out.println(link.getText() + ": " + link.getAttribute("href"));

        // numbers of links and text
        System.out.println("######################################################");
        List<WebElement> links1 = driver.findElements(By.xpath("//div[contains(text(),'Wedding')]"));
        int numberOfLinks1 = links.size();
        System.out.println("The number of links:"+ numberOfLinks1);
        for (WebElement link: links1)
            System.out.println(link.getText());
    }

    @AfterEach
    void tearDown() throws Exception {
         driver.quit();
    }
}

