package pages;

import models.OrderDetails;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderDetails getOrderDetails() {
        return new OrderDetails();
    }
}
