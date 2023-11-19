package gui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailPage extends BasePage {

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsButton;

    public PersonalDetailPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickContactDetailsButton() {
        contactDetailsButton.click();
    }
}
