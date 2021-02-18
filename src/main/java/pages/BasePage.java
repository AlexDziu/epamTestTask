package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void turnDown() {
        if (DRIVER_THREAD_LOCAL.get() != null) {
            getDriver().quit();
            DRIVER_THREAD_LOCAL.remove();
        }
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    protected WebElement waitUntilVisible(By locator, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilClickable(By locator, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

}
