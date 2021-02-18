package tests;

import driverManager.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    @Before
    public void setUp() {
        DriverManager.setUpDriver();
    }

    @After
    public void turnDown() {
        DriverManager.quiteDriver();
    }
}
