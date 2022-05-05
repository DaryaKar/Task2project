package UI_tests;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {


    @AfterTest
    public void kill() {
        DriverManager.closeDriver();
    }
}
