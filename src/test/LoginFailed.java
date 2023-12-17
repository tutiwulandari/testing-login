package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginFailed {
    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");
        ChromeOptions options = new ChromeOptions();
    }
}
