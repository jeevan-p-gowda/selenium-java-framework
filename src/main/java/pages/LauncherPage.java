package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LauncherPage extends BasePage {
    private WebDriver webDriver;

    public LauncherPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }


    public boolean navigateTo(String url) {
        webDriver.get(url);
        return isSiteLoaded();
    }

    public boolean isSiteLoaded() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
