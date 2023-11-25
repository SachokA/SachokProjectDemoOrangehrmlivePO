package base;

import gui.core.WebDriverFactory;
import gui.pages.ResetPasswordPage;
import gui.steps.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static gui.core.WebDriverInstance.driverInstance;

public abstract class BaseTest {
    public static LoginSteps loginSteps;
    public static ResetPasswordPageSteps resetPasswordPageSteps;
    public static ResetPasswordPage resetPasswordPage;
    public static ResetPasswordLinkSentSuccessfullySteps resetPasswordLinkSentSuccessfullySteps;
    public static DashboardSteps dashboardSteps;
    public static ContactDetailsSteps contactDetailsSteps;

    @BeforeEach
    public void setUp() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driverInstance().setDriver(driver);
        loginSteps = new LoginSteps();
        resetPasswordPageSteps = new ResetPasswordPageSteps();
        resetPasswordPage = new ResetPasswordPage();
        resetPasswordLinkSentSuccessfullySteps = new ResetPasswordLinkSentSuccessfullySteps();
        dashboardSteps = new DashboardSteps();
        contactDetailsSteps = new ContactDetailsSteps();
    }

    @AfterEach
    public void teardown() {
        WebDriver driver = driverInstance().getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
