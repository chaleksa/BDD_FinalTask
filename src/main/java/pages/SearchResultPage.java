package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'did-you-mean')]//h1")
    private WebElement wordSuggestionBanner;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWordSuggestionBannerVisible() {
        return wordSuggestionBanner.isDisplayed();
    }

    public String wordSuggestionBannerText() {
        return wordSuggestionBanner.getText();
    }


}
