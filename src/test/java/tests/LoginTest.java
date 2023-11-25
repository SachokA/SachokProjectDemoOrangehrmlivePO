package tests;

import base.BaseTest;
import models.LoginInfo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JsonFileReader;


public class LoginTest extends BaseTest {
    private static final Logger log = Logger.getLogger(LoginTest.class);

    @Test
    public void loginTestWithValidData() {

        LoginInfo loginInfo = JsonFileReader.readJsonFile("src/test/java/tests/LoginTestData.json", LoginInfo.class);
        log.debug("User name: " + loginInfo.getUserName());
        log.debug("User password: " + loginInfo.getPassword());
        final String expectedTitle = "OrangeHRM";
        final String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        log.info("Open URL");
        loginSteps.open();
        log.info("Set user Credential useName and password: " + loginInfo.getUserName() + " , " + loginInfo.getPassword());
        loginSteps.setUserCredential(loginInfo.getUserName(), loginInfo.getPassword());
        String actualTitle = loginSteps.getPageTitle();
        String actualURL = loginSteps.getPageURL();
        log.info("Actual title: " + actualTitle);
        log.info("Actual URL: " + actualURL);

        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void loginTestWithInvalidData() {

        final String userName = "SomeMan";
        final String userPassword = "admin123";

        log.info("Open URL");
        loginSteps.open();
        log.info("Set user Credential useName and password: " + userName + " , " + userPassword);
        loginSteps.setUserCredential(userName, userPassword);

        Assertions.assertTrue(loginSteps.isPresentElement());
        Assertions.assertEquals("Invalid credentials", loginSteps.getMessage());
    }
}
