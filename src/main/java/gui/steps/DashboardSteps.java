package gui.steps;

import gui.pages.PersonalDetailPage;

public class DashboardSteps extends BaseSteps {

    public PersonalDetailPage clickMyInfoButton() {
        dashboardPage.clickMyInfoButton();
        return new PersonalDetailPage();
    }
}
