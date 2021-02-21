package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.util.Collections.*;

@Slf4j
public class GoogleResultsPage extends BasePage {

    @FindBy(xpath = "//*[@class='g']//h3/parent::a")
    private WebElement resultLinks;

    @FindBy(xpath = "//a[@id='pnnext']")
    private WebElement nextPageButton;

    public GoogleResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public GoogleResultsPage clickOnFirstPage() {
        log.info("Click on the first site");
        List<WebElement> listOfLinks = singletonList(resultLinks);
        listOfLinks.get(0).click();
        return this;
    }

    public boolean domainNameIsPresent(String domainName, int numberOfPages) {
        log.info("Checking that domain name is present on the pages");
        int currentPage = 1;
        while (currentPage <= numberOfPages) {
            List<WebElement> listOfLinks = singletonList(resultLinks);
            for (WebElement link : listOfLinks) {
                if (link.getText().contains(domainName)) {
                    return true;
                }
            }
            nextPageButton.click();
            currentPage++;
        }
        return false;
    }
}
