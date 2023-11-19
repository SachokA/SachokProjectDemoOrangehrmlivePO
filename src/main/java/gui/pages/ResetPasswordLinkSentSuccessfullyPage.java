package gui.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordLinkSentSuccessfullyPage extends BasePage {
    @FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
    private WebElement formForgottenPasswordTitle;

    public ResetPasswordLinkSentSuccessfullyPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTitleFormSuccessfully() {
        return formForgottenPasswordTitle.getText();
    }


}
