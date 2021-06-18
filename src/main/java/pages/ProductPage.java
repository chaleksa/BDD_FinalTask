package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@id='selectQuantity']//span[@class='a-dropdown-container']")
    private WebElement selectQuantityDropdown;

    @FindBy(xpath = "//div[contains(@class,  'a-dropdown') and @aria-hidden='false']//li[@role='option']")
    private List<WebElement> quantityOptions;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='attach-desktop-sideSheet']")
    private WebElement rightSideBar;

    @FindBy(xpath = "//div[@id='attach-desktop-sideSheet']//span[@id='attach-sidesheet-view-cart-button']//input[@class='a-button-input']")
    private WebElement rightSideBarCartButton;

    @FindBy(xpath = "//div[@id='attach-desktop-sideSheet']//a[@id='attach-close_sideSheet-link']")
    private WebElement closeRightSideBarIcon;

    @FindBy(xpath = "//div[@class='card-peek-content']//input[@class='a-button-input']")
    private List<WebElement> additionalProductsAddToCartButtons;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectQuantityDropdown() {
        selectQuantityDropdown.click();
    }

    public void selectProductQuantityFromDropdown(final int quantity) {
        quantityOptions.get(quantity - 1).click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public boolean isRightSideBarVisible() {
        return rightSideBar.isDisplayed();
    }

    public void clickRightSideBarCartButton() {
        rightSideBarCartButton.click();
    }

    public WebElement getRightSideBarElement() {
        return rightSideBar;
    }

    public WebElement getRightSideBarCartButtonElement() {
        return rightSideBarCartButton;
    }

    public void clickCloseRightSideBarIcon() {
        closeRightSideBarIcon.click();
    }

    public void clickAllAdditionalProductsAddToCartButtons() {
        for (WebElement element : additionalProductsAddToCartButtons) {
            element.click();
        }
    }

}
