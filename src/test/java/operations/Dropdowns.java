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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdowns {
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
        driver.get("https://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }
    @AfterEach
    void tearDown() throws Exception

    {
      // driver.quit();
    }

    @Test
    void dropdowns() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.name("dropdown"));
        Select s = new Select(dropdown);
        s.selectByVisibleText("Drop Down Item 6");
        s.selectByIndex(1);
        String optionSelected = s.getFirstSelectedOption().getText();
        System.out.println("Currently selected option: " + optionSelected);

        //1
        List<WebElement> list = driver.findElements(By.name("dropdown"));
        for (WebElement element: list)
            System.out.println(element.getText());
        //2
        List<WebElement> options = s.getOptions();
            System.out.println("Number of options" + options.size());
       // Thread.sleep(3000);
    }
    @Test
    void multiselect()
    {
        WebElement multiSelect = driver.findElement(By.name("multipleselect[]"));
        Select s = new Select(multiSelect);
        s.deselectAll();
        s.selectByIndex(1);
        s.selectByIndex(2);

    }



}
