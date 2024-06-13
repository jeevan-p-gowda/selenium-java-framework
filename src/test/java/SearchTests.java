import drivers.DriverFactory;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LauncherPage;

import java.util.List;

public class SearchTests {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() {
        //Arrange
        String searchItem = "Product";
        String searchKey = "Product";
        String browser = "chrome";
//        WebDriver webDriver = new ChromeDriverManager().create();
        WebDriver webDriver = new DriverFactory().create(browser);
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Product> searchProducts = homepage.getSearchItems();

        //Assert
        Assert.assertEquals(1, searchProducts.size());
        Assert.assertFalse(searchProducts.stream().allMatch(product -> product.getName().contains(searchKey)));
    }
}
