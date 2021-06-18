package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SearchResultPage searchResultPage;
    CreateAccountPage createAccountPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    HeadphonesPage headphonesPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User makes search by {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSearchButton();
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        assertTrue(homePage.checkSearchFieldVisibility());
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Then("User checks that current url contains {string}")
    public void checkThatCurrentUrlContainsRequest(final String searchRequest) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(searchRequest));
    }

    @Then("User checks that he gets message with {string} suggestion")
    public void checkMessageWithCorrectedWordSuggestionVisibility(final String searchRequest) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(searchRequest));
    }


    @Then("User checks word suggestion banner visibility")
    public void checksWordSuggestionBannerVisibility() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        assertTrue(searchResultPage.isWordSuggestionBannerVisible());
    }

    @And("User checks that message contains {string} suggestion")
    public void checkThatMessageContainsCorrectedWordSuggestion(final String correctedWord) {
        assertTrue(searchResultPage.wordSuggestionBannerText().contains(correctedWord));
    }

    @And("User opens Sigh-in page")
    public void navigateToSighInPage() {
        homePage.clickNavbarSignInButton();
        signInPage = pageFactoryManager.getSignInPage();
    }

    @And("User clicks Create account button")
    public void clickCreateAccountButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickCreateAccountButton();
    }

    @When("User clicks Continue button")
    public void clickContinueButton() {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        createAccountPage.clickOnContinueButton();
    }

    @And("User checks that Re-enter password field has no alerts")
    public void checkThatPasswordCheckAlertIsNotVisible() {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertFalse(createAccountPage.checkReenterPasswordMissingAlertVisibility());
    }

    @Then("User checks that Name, Email and Password fields have an alerts")
    public void checkNameEmailAndPasswordFieldsAlertsVisibility() {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.isNameMissingAlertVisible());
        assertTrue(createAccountPage.isEmailMissingAlertVisible());
        assertTrue(createAccountPage.isPasswordMissingAlertVisible());
    }

    @And("User checks text for Name field alert is {string}")
    public void checkTextForNameFieldAlert(final String alertText) {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.getNameMissingAlertText().contains(alertText));
    }

    @And("User checks text for Email field alert is {string}")
    public void checkTextForEmailFieldAlert(final String alertText) {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.getEmailMissingAlertText().contains(alertText));
    }

    @And("User checks text for Password field alert is {string}")
    public void checkTextForPasswordFieldAlert(final String alertText) {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.getPasswordMissingAlertText().contains(alertText));
    }

    @When("User types {string} to email input field")
    public void typeEmailToInputField(final String email) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.enterTextToEmailField(email);
    }

    @And("User clicks continue button")
    public void clickContinueButtonToSignin() {
        signInPage.clickContinueButton();
    }

    @Then("User checks that auth error message is visible")
    public void checkThatAuthErrorMessageIsVisible() {
        assertTrue(signInPage.isAuthErrorMessageVisible());
    }

    @And("User clicks on top sellers product")
    public void clickTopSellersProduct() {
        homePage.clickTopSellersProduct();
    }

    @When("User changes product quantity to {int}")
    public void setProductQuantity(final int quantity) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickSelectQuantityDropdown();
        productPage.selectProductQuantityFromDropdown(quantity);
    }


    @And("User clicks add to cart button")
    public void clickAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that sidebar appears")
    public void checkSidebarVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getRightSideBarElement());
        assertTrue(productPage.isRightSideBarVisible());
    }

    @And("User clicks Cart button on side bar")
    public void clickCartButtonOnSideBar() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getRightSideBarCartButtonElement());
        productPage.clickRightSideBarCartButton();
    }

    @And("User checks that products quantity in cart is {string}")
    public void checkProductsQuantityInCart(final String quantity) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(quantity, homePage.getValueFromCartIcon());
    }

    @When("User clicks Delete on all products in cart")
    public void deleteAllProductsInCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        int productsCount = shoppingCartPage.getProductsInCartCount();
        shoppingCartPage.removeCartItemByIndex(0);
        for (int i = 1; i < productsCount; i++) {
            shoppingCartPage.removeCartItemByIndex(1);
            shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        }
    }

    @And("User adds all additional products from side bar")
    public void addAllAdditionalProductsFromSideBar() {
        productPage.clickAllAdditionalProductsAddToCartButtons();
    }


    @And("User clicks Sign-In button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @And("User types {string} to password input field")
    public void typePasswordToPasswordInputField(final String password) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.enterTextToPasswordField(password);
    }

    @Then("User checks that he sees his {string} on top navigation panel")
    public void checkUserNameIsOnTopNavigationPanel(final String name) {
        assertTrue(homePage.getTopPanelHelloMessageText().contains(name));

    }

    @And("User clicks on menu button")
    public void clickMenuButton() {
        homePage.waitElementToBeClickable(DEFAULT_TIMEOUT, homePage.getMenuButton());
        homePage.clickMenuButton();
    }

    @And("User clicks on Electronics menu element")
    public void clickElectronicsMenuElement() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitElementToBeClickable(DEFAULT_TIMEOUT, homePage.getElectronicsMenuElement());
        homePage.clickElectronicsMenuElement();
    }

    @And("User clicks on HeadPhones menu element")
    public void clickHeadPhonesMenuElement() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitElementToBeClickable(DEFAULT_TIMEOUT, homePage.getHeadPhonesMenuElement());
        homePage.clickHeadPhonesMenuElement();
    }

    @And("User chooses filter by Sony brand")
    public void chooseFilterByBrand() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        headphonesPage = pageFactoryManager.getHeadphonesPage();
        headphonesPage.clickSonyBrandFilterOption();
    }


    @Then("User checks that all products belong to Sony brand")
    public void checkThatAllProductsBelongToSonyBrand() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement element : headphonesPage.getProductsTitles()) {
            assertTrue(element.getText().toLowerCase().contains("sony"));
        }
    }

    @When("User chooses filter by price from {string} to {string}")
    public void applyFilterByPriceFromMinPriceToMaxPrice(final String minPrice, final String maxPrice) {
        headphonesPage = pageFactoryManager.getHeadphonesPage();
        headphonesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        headphonesPage.enterTextToMinPriceField(minPrice);
        headphonesPage.enterTextToMaxPriceField(maxPrice);
    }

    @Then("User checks that all products have price from {string} to {string}")
    public void checksThatAllProductsHavePriceFromMinPriceToMaxPrice(final String minPrice, final String maxPrice) {
        headphonesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement element : headphonesPage.getProductsPrices()) {
            String price = element.getText();
            price = price.replaceAll("[^0-9]", "");
            assertTrue(Integer.parseInt(price) >= Integer.parseInt(minPrice) && Integer.parseInt(price) <= Integer.parseInt(maxPrice));
        }
    }

    @Then("User checks that price filters were not applied")
    public void checkThatPriceFiltersWereNotApplied() {
        assertTrue(headphonesPage.isEmptyMinPriceInputVisible());
        assertTrue(headphonesPage.isEmptyMaxPriceInputVisible());
    }

    @And("User checks password field visibility")
    public void checkPasswordFieldVisibility() {
        assertTrue(signInPage.isPasswordInputFieldVisible());
    }

    @And("User checks Sign-In button visibility")
    public void checkSignInButtonVisibility() {
        assertTrue(signInPage.isSignInButtonVisible());
    }

    @And("User checks Remember me checkbox visibility")
    public void checkRememberMeCheckboxVisibility() {
        assertTrue(signInPage.isRememberMeCheckboxVisible());
    }

    @And("User clicks Remember me checkbox")
    public void clickRememberMeCheckbox() {
        signInPage.clickRememberMeCheckbox();
    }

    @Then("User checks that captcha is on the page")
    public void checkThatCaptchaVisibility() {
        assertTrue(signInPage.isCaptchaImageContainerVisible());
    }
}
