package Pages;

import driver_manager.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    public WebElement findByXpath(String xpath, Duration duration) {
        return driver.findElement(waitForElementVisible(By.xpath(xpath), duration));
    }

    private WebDriverWait getWaiter(Duration duration) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, duration);
        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return webDriverWait;
    }

    public By waitForElementVisible(By findStrategy, Duration duration) {
        getWaiter(duration).until(visibilityOfElementLocated(findStrategy));
        return findStrategy;
    }
}
