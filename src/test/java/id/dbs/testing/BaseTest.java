package id.dbs.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        String osName = System.getProperty("os.name");
        String archName = System.getProperty("os.arch");
        var isMac = osName != null && osName.toLowerCase().contains("mac");
        var isSiliconChip = archName != null && archName.equals("aarch64");

        if (isMac && isSiliconChip) {
            System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        } else {
            URL resource = BaseTest.class.getClassLoader().getResource("chromedriver");
            if (resource != null) {
                File driverPath = new File(resource.getFile());
                System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
            } else {
                System.out.println("Chromedriver not found in resources!");
            }
        }

        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
