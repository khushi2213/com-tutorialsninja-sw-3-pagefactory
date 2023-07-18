package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class DesktopTest extends BaseTest {
    DesktopPage desktopPage;
    ShoppingCartPage shoppingcartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktopPage = new DesktopPage();
        shoppingcartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regeression"})
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        desktopPage.mouseHoverAndClickDesktops();
        //1.2 Click on “Show All Desktops”
        desktopPage.clickOnShowAllDeskTops();
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectSortByZToA("Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        desktopPage.verifyProductArrangeInDescendingOrder();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab. and click
        desktopPage.mouseHoverAndClickDesktops();
        // 2.2 Click on “Show All Desktops”
        desktopPage.clickOnShowAllDeskTops();
        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.selectSortByAToZ("Name: A to Z");
        // 2.4 Select product “HP LP3065”
        desktopPage.selectProduct();
        // 2.5 Verify the Text "HP LP3065"
        Assert.assertEquals(desktopPage.getHPText(), "HP LP3065", "HP LP3065 Product not display");
        // 2.6 Select Delivery Date "2023-11-13"
        desktopPage.selectDeliveryDate("2023-11-13");
        //2.7.Enter Qty "1” using Select class.
        //  desktopPage.enterQty();
        // 2.8 Click on “Add to Cart” button
        waitUntilVisibilityOfElementLocated(By.id("input-option225"), 5);
        desktopPage.addToCart();
        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertEquals(desktopPage.getSuccessMessageText(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×", "Product not added to cart");
        //  2.10 Click on link “shopping cart” display into success message
        shoppingcartPage.shoppingCartClick();
        //  2.11 Verify the text "Shopping Cart"
        Assert.assertEquals(desktopPage.getShoppingcartText(), "Shopping Cart  (1.00kg)", "Shopping cart not displayed");
        //change the currency to  £ sterling
        shoppingcartPage.clickOnCurrencyTab();
        shoppingcartPage.clickOnPoundSterling();
        //  2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals(desktopPage.getHPProdcutText(), "HP LP3065", "HP LP3065 not displayed");
        //  2.13 Verify the Delivery Date "2023-11-30"
        Assert.assertEquals(desktopPage.getdeliveryDateText(), "Delivery Date:2023-11-30", "2023-11-30 not displayed");
        //  2.14 Verify the Model "Product21"
        Assert.assertEquals(desktopPage.getProdcut21Text(), "Product 21", "product21 not displayed");
        //  2.15 Verify the Todal "£74.73"
        Assert.assertEquals(desktopPage.getTotalCostText(), "£74.73", "total not matched");
    }

}
