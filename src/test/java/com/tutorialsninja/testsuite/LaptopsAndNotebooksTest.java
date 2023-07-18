package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    ShowAllLaptopsAndNotebooksPage laptopAndNotebooksPage;
    ShoppingCartPage shoppingCartpage;
    RegisterPage myAccountRegisterPage;
    CheckOutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopAndNotebooksPage = new ShowAllLaptopsAndNotebooksPage();
        shoppingCartpage = new ShoppingCartPage();
        myAccountRegisterPage = new RegisterPage();
        checkoutPage = new CheckOutPage();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickLaptopsAndNotebooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        laptopAndNotebooksPage.originalProductPriceList();
        //1.3 Select Sort By "Price (High > Low)"
        laptopAndNotebooksPage.sortByPriceHightoLow();
   //     laptopAndNotebooksPage.afterSortByPrice();
        //1.4 Verify the Product price will arrange in High to Low order.
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        // Select currency as £ Pound Sterling
      //  shoppingCartpage.clickOnCurrencyTab();
     //   shoppingCartpage.clickOnPoundSterling();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickLaptopsAndNotebooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndNotebooksPage.sortByPriceHightoLow();
        //2.4 Select Product “MacBook”
        laptopAndNotebooksPage.clickOnMacbook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(laptopAndNotebooksPage.getMacbooktext(), "MacBook", "Macbook product not found");
        //2.6 Click on ‘Add To Cart’ button
        waitUntilVisibilityOfElementLocated(By.xpath("//button[@id='button-cart']"), 5);
        laptopAndNotebooksPage.addToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals(laptopAndNotebooksPage.getSuccesstext(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Not correct text");
        // 2.8 Click on link “shopping cart” display into success message
        laptopAndNotebooksPage.clickShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals(laptopAndNotebooksPage.getShoppingCartText(), "Shopping Cart  (0.00kg)", "Shopping cart message not found");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(laptopAndNotebooksPage.getMacbookNameText(), "MacBook", "Product name not matched");
        //2.11 Change Quantity "3"
     //   laptopAndNotebooksPage.clearQty();
        laptopAndNotebooksPage.changeQty();
        //2.12 Click on “Update”Tab
        laptopAndNotebooksPage.clickUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(laptopAndNotebooksPage.getModifiedSuccessText(), "Success: You have modified your shopping cart!\n" +
                "×", "Cart not modified");
        //2.14 Verify the Total £737.45
   //     Assert.assertEquals(laptopAndNotebooksPage.getTotaltext(), "£737.45", "Total cost do not match");
        //2.15 Click on “Checkout” button
        laptopAndNotebooksPage.clickCheckout();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(laptopAndNotebooksPage.getCheckoutText(), "Checkout", "text not found");
        //2.17 Verify the Text “New Customer”
        waitUntilVisibilityOfElementLocated(By.xpath("//h1[contains(text(),'Checkout')]"), 5);
    //    Assert.assertEquals(laptopAndNotebooksPage.getNewCustomerText(), "New Customer", "Text not found");
        //2.18 Click on “Guest Checkout” radio button
        laptopAndNotebooksPage.clickOnGuestCheckoutButton();
        //2.19 Click on “Continue” tab
        laptopAndNotebooksPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.enterFirstname("Khushi");
        checkoutPage.enterLastName("Pandey");
        checkoutPage.enterEmail("k123@gmail.com");
        checkoutPage.enterTelephone("07778696589");
        checkoutPage.enterAddress("Brooke street");
        checkoutPage.enterCity("London");
        checkoutPage.enterPostcode("HA1 3GH");
        checkoutPage.enterCountry("United Kingdom");
        checkoutPage.enterState("England");
        //2.21 Click on “Continue” Button
        checkoutPage.clickContinueButtonguest();
        //2.22 Add Comments About your order into text area
        checkoutPage.enterCommentInTextAea("Thank you");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.checkTermsAndCondtionCheckBox();
        //2.24 Click on “Continue” button
        checkoutPage.clickContinueButtonpayment();
        //2.25 Verify the message “Warning: Payment method required
   //     Assert.assertEquals(checkoutPage.GetWarningMessageText(), "Warning: Payment method required!" + "×", "message not found");
    }
}
