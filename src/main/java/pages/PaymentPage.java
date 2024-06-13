package pages;

import models.Card;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentPage enterCardDetails(Card cardDetails) {
        return this;
    }

    public OrderConfirmationPage payNow() {
        return new OrderConfirmationPage(webDriver);
    }
}
