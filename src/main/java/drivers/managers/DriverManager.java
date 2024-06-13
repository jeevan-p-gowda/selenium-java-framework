package drivers.managers;

import org.openqa.selenium.WebDriver;

public interface DriverManager<WebDriver> {
    /**
     * Create a new driver
     * @return
     */
    WebDriver create();
}
