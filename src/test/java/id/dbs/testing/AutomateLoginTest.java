package id.dbs.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

class AutomateLoginTest {

    public static final String LINK_WEB = "https://the-internet.herokuapp.com/login";

    @BeforeEach
    public void setup() {
        String osName = System.getProperty("os.name");
        String archName = System.getProperty("os.arch");
        var isMac = osName != null && osName.toLowerCase().contains("mac");
        var isSiliconChip = archName != null && archName.equals("aarch64");
        if(isMac && isSiliconChip){
            System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");
        }

    }
    @Test
    void LoginFailed() {
//        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get(LINK_WEB);
        WebElement username = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.className("radius"));
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
    void LoginSuccess() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get(LINK_WEB);
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink, LINK_WEB);
        WebElement username = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.className("radius"));
        username.sendKeys("tomsmith");
        pass.sendKeys("SuperSecretPassword!");
        btnLogin.click();
        driver.quit();

    }


}
