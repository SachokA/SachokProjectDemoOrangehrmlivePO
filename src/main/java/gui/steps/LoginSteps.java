package gui.steps;

import gui.pages.ResetPasswordPage;
import org.openqa.selenium.WebElement;

public class LoginSteps extends BaseSteps {

    public void open() {
        loginPage.open();
    }

    public void setUserCredential(String userName, String userPassword) {
        loginPage.setUserName(userName);
        loginPage.setUserPassword(userPassword);
        loginPage.pressLoginButton();
    }

    public String getPageTitle() {
        return loginPage.getPageTitle();
    }

    public String getPageURL() {
        return loginPage.getPageURL();
    }

    public void clickForgottenPassword() {
        loginPage.pressForgottenPasswordButton();
    }

    public Boolean isPresentElement() {
        return loginPage.isPresentInvalidCredentialsMessage();
    }

    public String getMessage() {
        return loginPage.getTextInvalidCredentialsMessage();
    }
}
