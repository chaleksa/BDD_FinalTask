package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id='auth-customerName-missing-alert']")
    private WebElement nameMissingAlert;

    @FindBy(xpath = "//div[@id='auth-customerName-missing-alert' and contains(@style, 'display: block')]//div[@class='a-alert-content']")
    private WebElement nameMissingAlertContent;

    @FindBy(xpath = "//div[@id='auth-email-missing-alert']")
    private WebElement emailMissingAlert;

    @FindBy(xpath = "//div[@id='auth-email-missing-alert' and contains(@style, 'display: block')]//div[@class='a-alert-content']")
    private WebElement emailMissingAlertContent;

    @FindBy(xpath = "//div[@id='auth-password-missing-alert']")
    private WebElement passwordMissingAlert;

    @FindBy(xpath = "//div[@id='auth-password-missing-alert' and contains(@style, 'display: block')]//div[@class='a-alert-content']")
    private WebElement passwordMissingAlertContent;

    @FindBy(xpath = "//div[@id='auth-passwordCheck-missing-alert']")
    private WebElement passwordCheckMissingAlert;


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNameMissingAlertVisible() {
        return nameMissingAlert.isDisplayed();
    }

    public String getNameMissingAlertText() {
        return nameMissingAlertContent.getText();
    }

    public boolean isEmailMissingAlertVisible() {
        return emailMissingAlert.isDisplayed();
    }

    public String getEmailMissingAlertText() {
        return emailMissingAlertContent.getText();
    }

    public boolean isPasswordMissingAlertVisible() {
        return passwordMissingAlert.isDisplayed();
    }

    public String getPasswordMissingAlertText() {
        return passwordMissingAlertContent.getText();
    }

    public boolean checkReenterPasswordMissingAlertVisibility() {
        return passwordCheckMissingAlert.isDisplayed();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

}
