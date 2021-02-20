package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultsPage extends BasePage {
    private final By resultLinks = By.xpath("//div[@id='rso']");
    private final By nextPageButton = By.xpath("//a[@id='pnnext']");

    public FirstLinkPage clickOnFirstPage() {
        List<WebElement> listOfLinks = findAll(resultLinks);
        listOfLinks.get(0).click();
        return new FirstLinkPage();
    }

    public boolean domainNameIsPresent(String domainName, int numberOfPages) {
        int currentPage = 1;
        while (currentPage <= numberOfPages) {
            List<WebElement> listOfLinks = findAll(resultLinks);
            for (WebElement link : listOfLinks) {
                if (link.getText().contains(domainName)) {
                    return true;
                }
            }
            find(nextPageButton).click();
            currentPage++;
        }
        return false;
    }
}
