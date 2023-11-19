package tests;

import base.BaseTest;
import gui.pages.ResetPasswordPage;
import gui.steps.LoginSteps;
import gui.steps.ResetPasswordLinkSentSuccessfullySteps;
import gui.steps.ResetPasswordPageSteps;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResetPasswordTest extends BaseTest {
    private static final Logger log = Logger.getLogger(ResetPasswordTest.class);

    @Test
    public void validationFormResetPasswordTest() {

        LoginSteps loginSteps = new LoginSteps();
        ResetPasswordPageSteps resetPasswordPageSteps = new ResetPasswordPageSteps();
        ResetPasswordLinkSentSuccessfullySteps resetPasswordLinkSentSuccessfullySteps = new ResetPasswordLinkSentSuccessfullySteps();

        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        final String expectedURLForgottenPassword = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        final String expectedTitleFormForgottenPassword = "Reset Password";

        log.info("Open URL");
        loginSteps.open();
        log.info("Clicking on forgotten password");
        loginSteps.clickForgottenPassword();

        String actualURL = resetPasswordPageSteps.getPageURL();
        String actualTitle = resetPasswordPageSteps.getPageTitle();
        log.info("Actual URL: " + actualURL);
        log.info("Actual title form: " + actualTitle);

        Assertions.assertEquals(expectedTitleFormForgottenPassword, actualTitle);
        Assertions.assertEquals(expectedURLForgottenPassword, actualURL);
        Assertions.assertTrue(resetPasswordPage.isDisplayedFormForgottenPasswordInputUserName());
        Assertions.assertTrue(resetPasswordPage.isDisplayedFormForgottenPasswordButtonSubmit());
        Assertions.assertTrue(resetPasswordPage.isDisplayedFormForgottenPasswordButtonCancel());
    }

    @Test
    public void changedPasswordTest() {
        final String userName = "Admin";
        LoginSteps loginSteps = new LoginSteps();
        ResetPasswordPageSteps resetPasswordPageSteps = new ResetPasswordPageSteps();
        ResetPasswordLinkSentSuccessfullySteps resetPasswordLinkSentSuccessfullySteps = new ResetPasswordLinkSentSuccessfullySteps();

        log.info("Open URL");
        loginSteps.open();
        log.info("Clicking on forgotten password");
        loginSteps.clickForgottenPassword();
        resetPasswordPageSteps.setUserNameForgottenPassword(userName);
        log.info("Set userName: " + userName);
        resetPasswordPageSteps.clickSubmit();

        String actualTitleForm = resetPasswordLinkSentSuccessfullySteps.getPageTitle();
        log.info("Actual title form: " + actualTitleForm);

        Assertions.assertEquals("Reset Password link sent successfully", actualTitleForm);
    }

}
