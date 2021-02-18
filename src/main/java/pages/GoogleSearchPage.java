package pages;

import org.openqa.selenium.By;

public class GoogleSearchPage extends BasePage {
    private final By searchField = By.xpath("//input[@name='q']");
    private final By searchButton = By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']");

//    public GoogleSearchPage open() {
//        String url = "https://www.google.com.ua/";
//        getDriver().get(url);
//        return this;
//    }

    public GoogleResultsPage searchFor(String searchRequest) {
        waitUntilVisible(searchField, 5).sendKeys(searchRequest);
        waitUntilClickable(searchButton, 5).click();
        return new GoogleResultsPage();
    }
}
