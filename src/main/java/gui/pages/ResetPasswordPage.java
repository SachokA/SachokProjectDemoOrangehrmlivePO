package gui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage {

    @FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
    private WebElement formForgottenTitle;

    @FindBy(xpath = "//input[@name='username' and @placeholder='Username']")
    private WebElement formForgottenPasswordInputUserName;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement formForgottenPasswordButtonCancel;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement formForgottenPasswordButtonSubmit;

    public ResetPasswordPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTitle() {
        return formForgottenTitle.getText();
    }

    public boolean isDisplayedFormForgottenPasswordInputUserName() {
        return formForgottenPasswordInputUserName.isDisplayed();
    }

    public boolean isDisplayedFormForgottenPasswordButtonCancel() {
        return formForgottenPasswordButtonCancel.isDisplayed();
    }

    public boolean isDisplayedFormForgottenPasswordButtonSubmit() {
        return formForgottenPasswordButtonSubmit.isDisplayed();
    }

    public void setInputUserName(String userName) {
        formForgottenPasswordInputUserName.sendKeys(userName);
    }

    public void clickSubmit() {
        formForgottenPasswordButtonSubmit.click();
    }
}
