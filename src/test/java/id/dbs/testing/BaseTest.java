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

        var resourceName = "chromedriver";
        var isWindows = osName != null && osName.toLowerCase().contains("windows");
        var arch64 = archName != null && archName.toLowerCase().contains("64");
        if (isWindows && arch64) {
            resourceName = "chromedriver_win_64.exe";
        } else if(isMac && isSiliconChip) {
            resourceName = "chromedriver_arm_64";
        }else if (isWindows) {
            resourceName = "chromedriver_win_32.exe";
        } else if (isMac) {
            resourceName = "chromedriver_mac_x64";
        } else {
            resourceName = "chromedriver_linux_64";
        }
        URL resource = BaseTest.class.getClassLoader().getResource(resourceName);
        if (resource != null) {
            File driverPath = new File(resource.getFile());
            driverPath.setExecutable(true);
            System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
        } else {
            System.out.println("Chromedriver not found in resources!");
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
