package drivers.managers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverCreator {
    public WebDriver create() {
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriverManager().create();
            case "edge":
                return new EdgeDriverManager().create();
            default:
                return new ChromeDriverManager().create();
        }
    }

    public WebDriverContext createDriverContext() {
        String browser = System.getProperty("browser", "chrome");
        DriverManager<WebDriver> webDriverDriverManager = getBrowserManagers().get(browser);
        return new WebDriverContext(webDriverDriverManager);
    }

    public Map<String, DriverManager<WebDriver>> getBrowserManagers() {
        Map<String, DriverManager<WebDriver>> driverManagerMap = new HashMap<>();
        driverManagerMap.put("chrome", new drivers.managers.ChromeDriverManager());
        driverManagerMap.put("firefox", new drivers.managers.FirefoxDriverManager());
        driverManagerMap.put("edge", new drivers.managers.EdgeDriverManager());
        return driverManagerMap;
    }
}
