package operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class WorkingWithActions {
    private WebDriver driver;
    private Actions builder;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() throws Exception {

        driver = new ChromeDriver();
        builder = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    void moveMouseWithAlert()
    {
        driver.get("http://book.theautomatedtester.co.uk/chapter4");
        WebElement mouseOver = driver.findElement(By.id("hoverOver"));

        builder.moveToElement(mouseOver).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    @Test
    void moveMouseWithOffset()
    {
        driver.get("https://www.webminal.org/");
        WebElement button = driver.findElement(By.linkText("Register"));
        //Point p = button.getLocation();
        builder.moveByOffset(button.getLocation().getX() + 6,button.getLocation().getY() + 6).click().perform();
        assertEquals("Join", driver.findElement(By.xpath("//h2")).getText());

    }

    private void assertEquals(String join, String h2) {
    }
    @Test
    void dragAndDrop()
    {
        driver.get("https://demoqa.com/droppable/");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        builder.dragAndDrop(source,target).perform();
        assertEquals("Dropped!", target.getText());
    }
    @Test
    void dragByOffset()
    {
        driver.get("https://demoqa.com/droppable/");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        int xSource = source.getLocation().getX();
        int ySource = source.getLocation().getY();

        int xTarget = target.getLocation().getX();
        int yTarget = target.getLocation().getY();

        int xMove = xTarget - xSource + 11;
        int yMove = yTarget - ySource + 11;

        builder.dragAndDropBy(source,xMove,yMove).perform();



    }
}
