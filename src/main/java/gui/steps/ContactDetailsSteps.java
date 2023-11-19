package gui.steps;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailsSteps extends BaseSteps {
    public void cleanFormContactDetails() {
        contactDetailsPage.cleanField(contactDetailsPage.street1Element);
        contactDetailsPage.cleanField(contactDetailsPage.street2Element);
        contactDetailsPage.cleanField(contactDetailsPage.stateElement);
        contactDetailsPage.cleanField(contactDetailsPage.cityElement);
        contactDetailsPage.cleanField(contactDetailsPage.homeTelephoneElement);
    }

    public void setFormContactDetails(String street1, String street2, String state, String city, String homeTelephone) {
        contactDetailsPage.sendText(contactDetailsPage.street1Element, street1);
        contactDetailsPage.sendText(contactDetailsPage.street2Element, street2);
        contactDetailsPage.sendText(contactDetailsPage.stateElement, state);
        contactDetailsPage.sendText(contactDetailsPage.cityElement, city);
        contactDetailsPage.sendCountry();
        contactDetailsPage.sendText(contactDetailsPage.homeTelephoneElement, homeTelephone);
    }

    public void clickSave() {
        contactDetailsPage.clickButtonSave();
    }

    public void refresh() {
        contactDetailsPage.refresh();
    }

    public void waitMessageSuccessfully() {
        contactDetailsPage.waitMessageSuccessfullySave();
    }

    public List<String> getFormContactDetails() {
        ArrayList<String> list = new ArrayList<>();
        list.add(contactDetailsPage.getText(contactDetailsPage.street1Element));
        list.add(contactDetailsPage.getText(contactDetailsPage.street2Element));
        list.add(contactDetailsPage.getText(contactDetailsPage.stateElement));
        list.add(contactDetailsPage.getText(contactDetailsPage.cityElement));
        list.add(contactDetailsPage.getText(contactDetailsPage.homeTelephoneElement));
        list.add(contactDetailsPage.countryElement.getText());
        return list;
    }
}
