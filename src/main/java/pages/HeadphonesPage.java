package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeadphonesPage extends BasePage {

    @FindBy(xpath = "//li[@id='p_89/Sony']//a[@data-routing]")
    private WebElement sonyBrandFilterOption;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    private List<WebElement> filteredProducts;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//h2/a[@class='a-link-normal a-text-normal']/span")
    private List<WebElement> productsTitles;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> productsPrices;

    @FindBy(xpath = "//input[@id='low-price']")
    private WebElement minPriceInput;

    @FindBy(xpath = "//input[@id='low-price' and not(@value)]")
    private WebElement emptyMinPriceInput;

    @FindBy(xpath = "//input[@id='high-price']")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//input[@id='high-price' and not(@value)]")
    private WebElement emptyMaxPriceInput;


    public HeadphonesPage(WebDriver driver) {
        super(driver);
    }

    public void clickSonyBrandFilterOption() {
        sonyBrandFilterOption.click();
    }

    public List<WebElement> getProductsTitles() {
        return productsTitles;
    }

    public List<WebElement> getProductsPrices() {
        return productsPrices;
    }

    public void enterTextToMinPriceField(final String minPrice) {
        minPriceInput.clear();
        minPriceInput.sendKeys(minPrice);
    }

    public void enterTextToMaxPriceField(final String maxPrice) {
        maxPriceInput.clear();
        maxPriceInput.sendKeys(maxPrice, Keys.ENTER);
    }

    public boolean isEmptyMinPriceInputVisible() {
        return emptyMinPriceInput.isDisplayed();
    }

    public boolean isEmptyMaxPriceInputVisible() {
        return emptyMaxPriceInput.isDisplayed();
    }
}
