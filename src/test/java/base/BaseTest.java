package base;

import gui.core.WebDriverFactory;
import gui.pages.LoginPage;
import gui.pages.ResetPasswordPage;
import gui.steps.LoginSteps;
import gui.steps.ResetPasswordLinkSentSuccessfullySteps;
import gui.steps.ResetPasswordPageSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static gui.core.WebDriverInstance.driverInstance;

public abstract class BaseTest {

    @BeforeEach
    public void setUp() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        ....driver settings
        driverInstance().setDriver(driver);
    }

    @AfterEach
    public void teardown() {
        WebDriver driver = driverInstance().getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
