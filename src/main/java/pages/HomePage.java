package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']")
    private WebElement selectDepartmentButton;

    @FindBy(xpath = "//select[@id='searchDropdownBox']//option[@value='search-alias=toys-and-games-intl-ship']")
    private WebElement toysAndGamesDepartmentOption;

    @FindBy(xpath = "//a[contains(@id, 'a-autoid') and contains(@href, 'signin')]")
    private WebElement navbarSignInButton;

    @FindBy(xpath = "//div[@id='main-content']//div[@id='desktop-1']//li[@role='listitem']")
    private List<WebElement> topSellers;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement topPanelHelloMessage;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@data-menu-id='5']")
    private WebElement electronicsMenuElement;

    @FindBy(xpath = "//a[contains(@href, 'nav_em__nav_desktop_sa_intl_headphones')  and @class='hmenu-item']")
    private WebElement headPhonesMenuElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public boolean checkSearchFieldVisibility() {
        return searchField.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }


    public void clickNavbarSignInButton() {
        navbarSignInButton.click();
    }

    public void clickTopSellersProduct() {
        topSellers.get(3).click();
    }

    public String getValueFromCartIcon() {
        return cartIcon.getText();
    }

    public String getTopPanelHelloMessageText() {
        return topPanelHelloMessage.getText();
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickElectronicsMenuElement() {
        electronicsMenuElement.click();
    }

    public void clickHeadPhonesMenuElement() {
        headPhonesMenuElement.click();
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getElectronicsMenuElement() {
        return electronicsMenuElement;
    }

    public WebElement getHeadPhonesMenuElement() {
        return headPhonesMenuElement;
    }
}
