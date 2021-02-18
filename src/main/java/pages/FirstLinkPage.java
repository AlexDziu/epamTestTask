package pages;

public class FirstLinkPage extends BasePage {

    public String getTitle() {
        return getDriver().getTitle();
    }
}
