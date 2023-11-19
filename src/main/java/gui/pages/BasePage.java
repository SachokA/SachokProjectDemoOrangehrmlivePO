package gui.pages;

import org.openqa.selenium.WebDriver;

import static gui.core.WebDriverInstance.driverInstance;

public abstract class BasePage {
    WebDriver getDriver() {
        return driverInstance().getDriver();
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public String getPageURL() {
        return getDriver().getCurrentUrl();
    }
}
