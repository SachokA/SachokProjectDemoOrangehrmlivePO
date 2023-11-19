package gui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final String pageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//p[contains(@class,'login-forgot')]")
    private WebElement forgottenPassword;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement invalidCredentialsMessage;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage open() {
        getDriver().get(pageURL);
        return this;
    }

    public void setUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void setUserPassword(String userPassword) {
        userPasswordInput.sendKeys(userPassword);
    }

    public void pressLoginButton() {
        buttonSubmit.click();
    }

    public ResetPasswordPage pressForgottenPasswordButton() {
        forgottenPassword.click();
        return new ResetPasswordPage();
    }

    public Boolean isPresentInvalidCredentialsMessage() {
        return invalidCredentialsMessage.isDisplayed();
    }

    public String getTextInvalidCredentialsMessage() {
        return invalidCredentialsMessage.getText();
    }
}
