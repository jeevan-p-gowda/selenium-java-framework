package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class PageActions {
    private WebDriver webDriver;
    private PageWaits waits;

    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }

    public PageActions click(By by) {
        waits.waitForElementToBeClickable(by).click();
        return this;
    }

    public PageActions click(WebElement element) {
        waits.waitForElementToBeClickable(element).click();
        return this;
    }

    public PageActions type(By by, String value) {
        waits.waitForElementToBePresent(by).sendKeys(value);
        return this;
    }

    public PageActions clear(By by) {
        waits.waitForElementToBePresent(by).clear();
        return this;
    }

    public String getText(By by) {
        return waits.waitForElementToBePresent(by).getText();
    }

    public String getChildText(WebElement parent, By by) {
        return parent.findElement(by).getText();
    }
}
