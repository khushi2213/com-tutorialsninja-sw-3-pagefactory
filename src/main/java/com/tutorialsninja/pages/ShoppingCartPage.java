package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartClick ;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTabClick ;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement poundSterlingClick ;


    //2.10 Click on link “shopping cart” display into success message
    public void shoppingCartClick() {
        clickOnElement(shoppingCartClick);
        Reporter.log("Click on "  + shoppingCartClick.toString());
  //      CustomListeners.test.log(Status.PASS, "shopping cart tab" + shoppingCartClick);
    }

    //currency tab click
    public void clickOnCurrencyTab() {
        clickOnElement(currencyTabClick);
        Reporter.log("Click on "  + currencyTabClick.toString());
   //     CustomListeners.test.log(Status.PASS, "currency tab" + currencyTabClick);
    }

    public void clickOnPoundSterling() {
        clickOnElement(poundSterlingClick);
        Reporter.log("Click on "  + poundSterlingClick.toString());
   //     CustomListeners.test.log(Status.PASS, "Pound sterling tab" + poundSterlingClick);
    }

}
