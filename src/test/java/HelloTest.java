import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class HelloTest {
    @Test
     public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Users/"+System.getProperty("adidata"));
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
//        driver.get("http://the-internet.herokuapp.com/login");
         String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
}
