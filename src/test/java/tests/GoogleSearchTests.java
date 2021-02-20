package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class GoogleSearchTests extends BaseTest {

    @Test
    public void verifyThatTitleContainsSearchedWord() {
        GoogleSearchPage searchPage = new GoogleSearchPage();
        String titlePage = searchPage.searchFor("automation")
                .clickOnFirstPage()
                .getTitle();
        Assert.assertTrue(titlePage.toLowerCase()
                .contains("automation"), "Page title [" + titlePage + "] not contains expected text");
    }

    @Test
    public void verifyThatSearchResultContainsDomainName() {
        int numberOfPages = Integer.parseInt(System.getProperty("numberOfPages"));
        String searchUrl = "testautomationday.com";
        GoogleSearchPage searchPage = new GoogleSearchPage();
        boolean domainFounded = searchPage.searchFor("automation")
                .domainNameIsPresent(searchUrl, numberOfPages);
        Assert.assertFalse(domainFounded, "Domain [" + searchUrl + "] is not present in the result");

    }
}
