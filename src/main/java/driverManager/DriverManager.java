package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.BasePage;

public class DriverManager {

    public static synchronized void setUpDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");
        if ("opera".equals(browser)) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().setSize(new Dimension(Integer.parseInt(System.getProperty("browserWidth")),
                Integer.parseInt(System.getProperty("browserWidth"))));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.get("https://" + System.getProperty("domain"));
        BasePage.setDriver(driver);
    }

    public static void quiteDriver() {
        BasePage.turnDown();
    }
}
