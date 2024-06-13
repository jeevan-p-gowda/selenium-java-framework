package pages;

import models.Address;
import models.Cart;
import models.Customer;
import org.openqa.selenium.WebDriver;

public class InformationPage extends BasePage {
    public InformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillShippingAddress(Address shippingAddress) {

    }

    public Customer getContactInformation() {
        return new Customer();
    }

    public Cart getCartDetails() {
        return new Cart();
    }

    public ShippingPage continueToShipping() {
        return new ShippingPage(webDriver);
    }
}
