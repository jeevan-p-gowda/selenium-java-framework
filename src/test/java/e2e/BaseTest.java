package e2e;

import drivers.managers.DriverCreator;
import internal.DriverStore;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static internal.DriverStore.getTestUniqueName;

public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod(alwaysRun = true)
    public synchronized void setup(ITestResult iTestResult) {
        WebDriver webDriver = new DriverCreator().createDriverContext().create();
        iTestResult.setAttribute(getTestUniqueName(iTestResult), webDriver);
    }

    @AfterMethod(alwaysRun = true)
    public synchronized void teardown(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getAttribute(getTestUniqueName(iTestResult));
        driver.quit();
    }

    protected synchronized WebDriver getDriver() {
        return new DriverStore().getWebDriver();
    }
}
