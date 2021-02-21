package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        DRIVER.set(webDriver);
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void turnDown() {
        if (DRIVER.get() != null) {
            getDriver().quit();
            DRIVER.remove();
        }
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    protected WebElement waitUntilVisible(WebElement element) {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilClickable(WebElement element) {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
