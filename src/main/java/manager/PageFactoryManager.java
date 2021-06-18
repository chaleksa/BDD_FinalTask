package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public CreateAccountPage getCreateAccountPage() {
        return new CreateAccountPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public HeadphonesPage getHeadphonesPage() {
        return new HeadphonesPage(driver);
    }

}
