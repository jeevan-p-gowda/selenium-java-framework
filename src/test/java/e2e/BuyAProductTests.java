package e2e;

import models.Cart;
import models.Customer;
import models.OrderDetails;
import models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class BuyAProductTests extends BaseTest {

    @Test(groups = "wip")
    public void verifyThatFirstTimeUserIsAbleToBuyAProduct() {
        //Arrange
        Customer newCustomer = new Customer().init();
        Product productToBuy = new Product().init();
        new LauncherPage(getDriver()).navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homePage = new HomePage(getDriver());
        ProductDetailsPage productDetailsPage = homePage.search(productToBuy.getSearchKeyword())
                .selectProduct(productToBuy.getName());

        CartQuickSummaryPage cartQuickSummaryPage = productDetailsPage
                .selectSize(productToBuy.getSize())
                .selectColor(productToBuy.getColor())
                .selectQuantity(productToBuy.getQuantity())
                .addToCart();

        Product productAddedToCart = cartQuickSummaryPage.getItemAddedToCart();


        //Assert
        productAddedToCart.assertThatNameSizeColorAreSame(productToBuy);

        //Act
        CartPage cartPage = cartQuickSummaryPage.viewMyCart();
        Cart cartDetails = cartPage.getCartDetails();
        List<Product> productsInCart = cartDetails.getProducts();

        //Assert
        Assert.assertEquals(1, productsInCart.size());
        Product productInCart = productsInCart.get(0);
        Assert.assertEquals(productInCart.getName(), productToBuy.getName());
        Assert.assertEquals(productInCart.getSize(), productToBuy.getSize());
        Assert.assertEquals(productInCart.getColor(), productToBuy.getColor());

        //Act
        cartPage.checkout();
        CreateAccountPage createAccountPage = new LoginPage(getDriver()).navigateToCreateAccountPage();
        createAccountPage.createAccount(newCustomer);

        // TODO: Complete the code from here as a challenge.
        InformationPage informationPage = new InformationPage(getDriver());
        informationPage.fillShippingAddress(newCustomer.getShippingAddress());
        Customer customerContactInformation = informationPage.getContactInformation();
        Cart cartDetailsInInformationPage = informationPage.getCartDetails();

        //Assert
        Assert.assertEquals(customerContactInformation.getFirstName(), newCustomer.getFirstName());
        Assert.assertEquals(customerContactInformation.getLastName(), newCustomer.getLastName());
        Assert.assertEquals(customerContactInformation.getEmail(), newCustomer.getEmail());

        Assert.assertEquals(cartDetailsInInformationPage.getSubTotal(), cartDetails.getSubTotal());
        Assert.assertEquals(cartDetailsInInformationPage.getCoupon(), cartDetails.getCoupon());
        Assert.assertEquals(cartDetailsInInformationPage.getCouponDiscount(), cartDetails.getCouponDiscount());
        Assert.assertEquals(cartDetailsInInformationPage.getTotal(), cartDetails.getTotal());


        //Act
        ShippingPage shippingPage = informationPage.continueToShipping();
        Cart cartDetailsInShippingPage = shippingPage.getUpdatedCartDetails();

        //Assert
        Assert.assertEquals(cartDetailsInShippingPage.getTaxes(), "₹51.24");

        //Act
        PaymentPage paymentPage = shippingPage.continueToPayment();
        OrderConfirmationPage orderConfirmationPage = paymentPage
                .enterCardDetails(newCustomer.getCardDetails())
                .payNow();
        OrderDetails orderDetails = orderConfirmationPage.getOrderDetails();

        //Assert
        Assert.assertFalse(orderDetails.getOrderId().isEmpty());
        Assert.assertEquals(orderDetails.getCustomerDetails(), newCustomer);
        Assert.assertEquals(orderDetails.getCartSummary(), cartDetailsInShippingPage);
    }
}
