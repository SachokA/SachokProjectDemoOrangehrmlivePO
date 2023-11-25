package gui.steps;

import models.ContactDetailsInfo;
import org.apache.log4j.Logger;
import utils.JsonFileReader;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailsSteps extends BaseSteps {
    private static final Logger log = Logger.getLogger(ContactDetailsSteps.class);
    private static ContactDetailsInfo contactDetailsInfo = JsonFileReader.readJsonFile("src/test/java/tests/ContactDetailsInfo.json", ContactDetailsInfo.class);
    public void cleanFormContactDetails() {
        contactDetailsPage.cleanField(contactDetailsPage.street1Element);
        contactDetailsPage.cleanField(contactDetailsPage.street2Element);
        contactDetailsPage.cleanField(contactDetailsPage.stateElement);
        contactDetailsPage.cleanField(contactDetailsPage.cityElement);
        contactDetailsPage.cleanField(contactDetailsPage.homeTelephoneElement);
    }

    public void setFormContactDetails(String street1, String street2, String state, String city, String homeTelephone) {
        log.info("Setting contact details: street1 = " + contactDetailsInfo.getStreet1());
        log.info("Setting contact details: street2 = " + contactDetailsInfo.getStreet2());
        log.info("Setting contact details: state = " + contactDetailsInfo.getState());
        log.info("Setting contact details: city = " + contactDetailsInfo.getCity());
        log.info("Setting contact details: homeNumberTelephone = " + contactDetailsInfo.getHomeNumberTelephone());
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
