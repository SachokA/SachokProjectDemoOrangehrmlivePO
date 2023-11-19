package gui.steps;

import gui.pages.ResetPasswordLinkSentSuccessfullyPage;

public class ResetPasswordPageSteps extends BaseSteps {
    public String getPageTitle() {
        return resetPasswordPage.getTitle();
    }

    public String getPageURL() {
        return resetPasswordPage.getPageURL();
    }

    public void setUserNameForgottenPassword(String userName) {
        resetPasswordPage.setInputUserName(userName);
    }

    public ResetPasswordLinkSentSuccessfullyPage clickSubmit() {
        resetPasswordPage.clickSubmit();
        return new ResetPasswordLinkSentSuccessfullyPage();
    }
}
