package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement quantityDropdownValue;

    @FindBy(xpath = "(//div[@data-name='Active Items']//div[not (@data-removed)]//span[@data-feature-id='delete']//input[@type='submit'])[last()]")
    private WebElement deleteLastCartItem;

    @FindBy(xpath = "//div[@data-name='Active Items']//div[@data-asin]")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//div[@data-name='Active Items']//span[@data-feature-id='delete']//input[@type='submit']")
    private List<WebElement> cartItemsDeleteButtons;


    @FindBy(xpath = "//div[@data-name='Active Items']//div[@data-removed]//div[@class='sc-list-item-removed-msg']")
    private WebElement removedProductInfo;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getProductsInCartCount() {
        return cartItems.size();
    }

    public void removeCartItemByIndex(final int itemIndex) {
        cartItemsDeleteButtons.get(itemIndex).click();
    }

}
