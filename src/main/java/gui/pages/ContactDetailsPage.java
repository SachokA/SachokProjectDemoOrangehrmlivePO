package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactDetailsPage extends BasePage {

    @FindBy(xpath = "//label[.='Street 1']/../following-sibling::div/input")
    public WebElement street1Element;

    @FindBy(xpath = "//label[.='Street 2']/../following-sibling::div/input")
    public WebElement street2Element;

    @FindBy(xpath = "//label[.='City']/../following-sibling::div/input")
    public WebElement cityElement;

    @FindBy(xpath = "//label[.='State/Province']/../following-sibling::div/input")
    public WebElement stateElement;

    @FindBy(xpath = "//label[.='Country']/../following-sibling::div/div")
    public WebElement countryElement;

    @FindBy(xpath = "//label[.='Home']/../following-sibling::div/input")
    public WebElement homeTelephoneElement;

    @FindBy(xpath = "//button[@type='submit' and normalize-space(text()='Save')]")
    public WebElement buttonSaveElement;

    @FindBy(xpath = "//div[@id='oxd-toaster_1']")
    public WebElement messageSuccessfullySaveElement;

    public ContactDetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void cleanField(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.click(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
    }

    public void sendText(WebElement element, String value) {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(element, value).build().perform();
    }

    public void sendCountry() {
        Actions actions = new Actions(getDriver());
        actions.click(countryElement).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void clickButtonSave() {
        buttonSaveElement.click();
    }

    public void waitMessageSuccessfullySave() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageSuccessfullySaveElement));
    }

    public void refresh() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().navigate().refresh();
        wait.until(ExpectedConditions.textToBePresentInElementValue(street1Element, street1Element.getText()));
    }

    public String getText(WebElement element) {
        return element.getAttribute("value");
    }
}
