package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverDesktop;
    @CacheLookup
    @FindBy(xpath="//a[text()='Desktops']")
    WebElement clickDesktop;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortZToA;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortAToZ;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement selectProduct;
    //WebElement enterQty = WebElement.name("quantity");
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartClick;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    By hpText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingcartText;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement hpProductText;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement product21Text;
    @CacheLookup
    @FindBy(xpath = "(//td[@class='text-right'][normalize-space()='£74.73'])[4]")
    WebElement totalcostText;
    @CacheLookup
    @FindBy(xpath = "//small[normalize-space()='Delivery Date:2023-11-30']")
    WebElement deliveryDateText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List< WebElement> dateList;

    @CacheLookup
    @FindBy(xpath = "//h4/a\"")
    List<WebElement> productList;

    public void selectSortByAToZ(String sortAscendingName) {
        selectByVisibleTextFromDropDown(selectSortAToZ, sortAscendingName);
        Reporter.log("Select Text" + sortAscendingName + " from drop down menu " + selectSortAToZ.toString());
        CustomListeners.test.log(Status.PASS, "Sorting ascending" + sortAscendingName);
    }

    public void mouseHoverAndClickDesktops() {
        mouseHoverToElementAndClick(mouseHoverDesktop);
        Reporter.log("Mouse hover and click " + mouseHoverDesktop.toString());
        CustomListeners.test.log(Status.PASS, "Desktop" + mouseHoverDesktop);
    }

    public void clickOnShowAllDeskTops() {
        clickOnElement(clickDesktop);
        Reporter.log(" click on " + clickDesktop.toString());
        CustomListeners.test.log(Status.PASS, "Desktop" + clickDesktop);
    }

    public void selectSortByZToA(String sortDescendingName) {
        selectByVisibleTextFromDropDown(selectSortZToA, "Name (Z - A)");
        Reporter.log("Select Text" + sortDescendingName + " from drop down menu " + selectSortAToZ.toString());
        CustomListeners.test.log(Status.PASS, "Sorting descending" + sortDescendingName);
    }

    public void selectProduct() {
        clickOnElement(selectProduct);
        Reporter.log(" click on " + selectProduct.toString());
        CustomListeners.test.log(Status.PASS, "Select product" + selectProduct);

    }

    public void addToCart() {
        clickOnElement(addToCartClick);
        Reporter.log(" click on " + addToCartClick.toString());
        CustomListeners.test.log(Status.PASS, "Add to cart tab" + addToCartClick);

    }

    public String getHPText() {
        Reporter.log("Get text  " + hpText.toString());
     //   CustomListeners.test.log(Status.PASS, "Text" + hpText);
        return getTextFromElement(hpText);
    }

    public String getSuccessMessageText() {
        Reporter.log(" Get text  " + successText.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" + successText);
        return getTextFromElement(successText);
    }

    public String getShoppingcartText() {
        Reporter.log(" Get text  " + successText.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" + successText);
        return getTextFromElement(shoppingcartText);
    }

    public String getHPProdcutText() {
        Reporter.log(" Get text  " + hpProductText.toString());
     //   CustomListeners.test.log(Status.PASS, "Text" + hpProductText);
        return getTextFromElement(hpProductText);
    }

    public String getProdcut21Text() {
        Reporter.log(" Get text  " + product21Text.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" + product21Text);
        return getTextFromElement(product21Text);
    }

    public String getTotalCostText() {
        Reporter.log(" Get text  " + totalcostText.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" + totalcostText);
        return getTextFromElement(totalcostText);
    }

    public String getdeliveryDateText() {
        Reporter.log(" Get text  " + deliveryDateText.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" + deliveryDateText);
        return getTextFromElement(deliveryDateText);
    }

    public void verifyProductArrangeInDescendingOrder() {
   //     CustomListeners.test.log(Status.PASS, "Get product " + productList);
        Reporter.log("Select option from " + productList.toString());
        List<WebElement> products = getListOfElements(productList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }

        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
    }

    public void selectDeliveryDate(String s) {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements(dateList);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
  //      CustomListeners.test.log(Status.PASS,"Select date from " + dateList);
        Reporter.log("select date " + dateList.toString());
    }
}
