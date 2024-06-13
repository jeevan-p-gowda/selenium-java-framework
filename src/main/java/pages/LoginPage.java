package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By createAccount = By.cssSelector("a[href='/account/register']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage navigateToCreateAccountPage() {
        actions.click(createAccount);
        return new CreateAccountPage(webDriver);
    }
}
