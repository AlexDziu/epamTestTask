package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class GoogleSearchPage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(css = ".UUbT9 [name='btnK']")
    private WebElement searchButton;

    public GoogleSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public GoogleResultsPage searchFor(String searchRequest) {
        log.info("Input text in the search field");
        waitUntilVisible(searchField).sendKeys(searchRequest);
        log.info("Click on the search button");
        waitUntilClickable(searchButton).click();
        return new GoogleResultsPage();
    }
}
