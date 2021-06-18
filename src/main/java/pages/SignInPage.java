package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='auth-error-message-box']")
    private WebElement authErrorMessage;

    @FindBy(xpath = "//div[@id='auth-captcha-image-container']")
    private WebElement captchaImageContainer;

    @FindBy(xpath = "//input[@name='rememberMe']")
    private WebElement rememberMeCheckbox;



    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void enterTextToEmailField(final String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void enterTextToPasswordField(final String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isAuthErrorMessageVisible() {
        return authErrorMessage.isDisplayed();
    }

    public boolean isPasswordInputFieldVisible() {
        return passwordInputField.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isRememberMeCheckboxVisible() {
        return rememberMeCheckbox.isDisplayed();
    }

    public void clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
    }

    public boolean isCaptchaImageContainerVisible() {
        return captchaImageContainer.isDisplayed();
    }
}
