package tests;

import driverManager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setUpDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void turnDown() {
        DriverManager.quiteDriver();
    }
}
