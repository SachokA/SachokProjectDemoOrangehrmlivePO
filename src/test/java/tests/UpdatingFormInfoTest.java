package tests;

import base.BaseTest;
import models.ContactDetailsInfo;
import models.LoginInfo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JsonFileReader;

import java.util.List;

public class UpdatingFormInfoTest extends BaseTest {

    private static final Logger log = Logger.getLogger(UpdatingFormInfoTest.class);

    @Test
    public void updatingFormInfoWithValidDate() throws InterruptedException {
        LoginInfo loginInfo = JsonFileReader.readJsonFile("src/test/java/tests/LoginTestData.json", LoginInfo.class);
        ContactDetailsInfo contactDetailsInfo = JsonFileReader.readJsonFile("src/test/java/tests/ContactDetailsInfo.json", ContactDetailsInfo.class);

        log.info("Open URL");
        loginSteps.open();
        log.debug("User name: " + loginInfo.getUserName());
        log.debug("User password: " + loginInfo.getPassword());
        loginSteps.setUserCredential(loginInfo.getUserName(), loginInfo.getPassword());
        dashboardSteps
                .clickMyInfoButton()
                .clickContactDetailsButton();
        Thread.sleep(1000);
        log.info("Clean form contact details");
        contactDetailsSteps.cleanFormContactDetails();
        contactDetailsSteps.
                setFormContactDetails(
                        contactDetailsInfo.getStreet1(),
                        contactDetailsInfo.getStreet2(),
                        contactDetailsInfo.getState(),
                        contactDetailsInfo.getCity(),
                        contactDetailsInfo.getHomeNumberTelephone());
        log.info("Click button save");
        contactDetailsSteps.clickSave();
        log.info("Waiting while appear message Successfully");
        contactDetailsSteps.waitMessageSuccessfully();
        log.info("Refresh page");
        contactDetailsSteps.refresh();

        Thread.sleep(1000);

        List<String> actualResult = contactDetailsSteps.getFormContactDetails();
        List<String> expectedResult = List.of(contactDetailsInfo.getStreet1(),
                contactDetailsInfo.getStreet2(),
                contactDetailsInfo.getState(),
                contactDetailsInfo.getCity(),
                contactDetailsInfo.getHomeNumberTelephone(), "Afghanistan");

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
