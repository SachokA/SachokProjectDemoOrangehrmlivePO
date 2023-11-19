package gui.steps;

import gui.pages.ContactDetailsPage;

public class PersonalDetailSteps extends BaseSteps {

    public ContactDetailsPage clickContactDetails() {
        personalDetailPage.clickContactDetailsButton();
        return new ContactDetailsPage();
    }
}
