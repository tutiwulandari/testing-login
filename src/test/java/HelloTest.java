import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class HelloTest {

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");

    }
    @Test
    public void LoginFailed() {
//        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        String linkWeb = "http://the-internet.herokuapp.com/login";
        driver.get(linkWeb);
        WebElement username =driver.findElement(By.id("username"));
        WebElement pass =driver.findElement(By.id("password"));
        WebElement btnLogin =driver.findElement(By.className("radius"));
        username.sendKeys("toms");
        pass.sendKeys("SuperSecretPassword!");
        btnLogin.click();
        WebElement lblError = driver.findElement(By.id("flash"));
        //verify
        String actualText = lblError.getText();
        String expText = "Your username is invalid!\n" +
                "×";
        System.out.println("act " + actualText);
        System.out.println(expText);
        Assert.assertEquals(actualText, expText);
        driver.quit();

    }
    @Test
    public void LoginSuccess() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        String linkWeb = "http://the-internet.herokuapp.com/login";
        driver.get(linkWeb);
//        String title = driver.getTitle();
//        System.out.println(title);
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink, linkWeb);
        WebElement username =driver.findElement(By.id("username"));
        WebElement pass =driver.findElement(By.id("password"));
        WebElement btnLogin =driver.findElement(By.className("radius"));
        username.sendKeys("tomsmith");
        pass.sendKeys("SuperSecretPassword!");
        btnLogin.click();
        driver.quit();

    }



}
