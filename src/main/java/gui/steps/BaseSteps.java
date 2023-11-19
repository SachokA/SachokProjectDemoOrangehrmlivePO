package gui.steps;

import gui.pages.*;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {
    LoginPage loginPage = new LoginPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    ResetPasswordLinkSentSuccessfullyPage resetPasswordLinkSentSuccessfullyPage = new ResetPasswordLinkSentSuccessfullyPage();

    DashboardPage dashboardPage = new DashboardPage();
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
    PersonalDetailPage personalDetailPage = new PersonalDetailPage();
}
