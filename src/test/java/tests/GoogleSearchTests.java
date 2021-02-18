package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.GoogleSearchPage;

public class GoogleSearchTests extends BaseTest {

    @Test
    public void verifyThatTitleContainsSearchedWord() {
        GoogleSearchPage searchPage = new GoogleSearchPage();
        String titlePage = searchPage.searchFor("automation")
                .clickOnFirstPage().getTitle();
        Assert.assertTrue(titlePage.toLowerCase().contains("automation"));
    }
}
