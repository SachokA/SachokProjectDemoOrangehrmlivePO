package gui.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return configChrome();
            case "firefox":
                return configFireFox();
            case "Edge":
                return configEdge();
            default:
                System.out.println("Wrong name browser: " + browser);
                return configChrome();
//                throw new RuntimeException("Unknown Browser " + browser);
        }
    }

    public static ChromeDriver configChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(30));
        return new ChromeDriver(options);
    }

    public static FirefoxDriver configFireFox() {
        FirefoxOptions options = new FirefoxOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return new FirefoxDriver(options);
    }

    public static EdgeDriver configEdge() {
        EdgeOptions options = new EdgeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return new EdgeDriver(options);
    }
}
