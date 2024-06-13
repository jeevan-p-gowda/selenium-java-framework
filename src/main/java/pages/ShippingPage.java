package pages;

import models.Cart;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage {
    public ShippingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Cart getUpdatedCartDetails() {
        return new Cart();
    }

    public PaymentPage continueToPayment() {
        return new PaymentPage(webDriver);
    }
}
