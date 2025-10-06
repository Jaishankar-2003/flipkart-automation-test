package tests;

import base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartSmokeTests extends BaseTest {

    @Test(priority = 1)
    public void verifyHomePageLoads()
    {
        HomePage home = new HomePage(driver);
        home.closeLoginPopup();
        Assert.assertTrue(home.isLogoVisible(), "Flipkart logo not visible!");
    }

    @Test(priority = 2)
    public void verifySearchProduct()
    {
        HomePage home = new HomePage(driver);
        home.searchProduct("iPhone 15");
        Assert.assertTrue(home.isSearchResultVisible(), "Search results not displayed!");
    }

    @Test(priority = 3)
    public void verifyAddToCart()
    {
        productpage product = new productpage(driver);
        product.openFirstProduct();
        product.addToCart();
        Assert.assertTrue(product.isAddedToCart(), "Product not added to cart!");
    }

    @Test(priority = 4)
    public void verifyRemoveFromCart()
    {
        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.removeProduct();
    }
}
