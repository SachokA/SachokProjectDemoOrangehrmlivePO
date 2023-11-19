package gui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoButton;

    public DashboardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickMyInfoButton() {
        myInfoButton.click();
    }
}
