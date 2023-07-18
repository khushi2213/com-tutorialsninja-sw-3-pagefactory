package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class ShowAllLaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement clickOnShowAllLaptopsandNoteBooks;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByPrice;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbookClick;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macbookText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
    WebElement successText;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement cartButton;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macbooknameText;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/input[1]")
    WebElement clearQty;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQty;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updatetab;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement modifiedSuccessText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutLink;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutText;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueLink;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;


    //1.2 Click on “Show AllLaptops & Notebooks”
    public void clickOnShowAllLaptopAndNoteBooks() {
        clickOnElement(clickOnShowAllLaptopsandNoteBooks);
        Reporter.log("Click on " + clickOnShowAllLaptopsandNoteBooks.toString());
        CustomListeners.test.log(Status.PASS, "Sorting descending" + clickOnShowAllLaptopsandNoteBooks);
    }

    // Get all the products price and stored into array list
    public void originalProductPriceList() {
        CustomListeners.test.log(Status.PASS, "Get product prices " + productsPrices);
        Reporter.log("Get product prices " + productsPrices.toString());
        List<WebElement> productsList = productsPrices;
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : productsList) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }

    }

    //1.3 Select Sort By "Price (High > Low)"

    public void sortByPriceHightoLow() {
        selectByVisibleTextFromDropDown(sortByPrice, "Price (High > Low)");
        Reporter.log("Sort price " + sortByPrice.toString());
        CustomListeners.test.log(Status.PASS, "Soting by price" + sortByPrice);
    }

    // After filter Price (High > Low) Get all the products price and stored into array list
    public void afterSortByPrice() {
        Reporter.log("List after sort by price" + productsPrices.toString());
        CustomListeners.test.log(Status.PASS, "Soting by price" + productsPrices);
        List<WebElement> productsList = productsPrices;
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : productsList) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
    }

    public void clickOnMacbook() {
        clickOnElement(macbookClick);
        Reporter.log("Click on " + macbookClick.toString());
        CustomListeners.test.log(Status.PASS, "Macbook" + macbookClick);
    }

    public String getMacbooktext() {
        Reporter.log("Gert text " + macbookText.toString());
        CustomListeners.test.log(Status.PASS, "Soting by price" + macbookText);
        return getTextFromElement(macbookText);
    }

    public void addToCart() {
        clickOnElement(cartButton);
        Reporter.log("Click on " + cartButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + cartButton);

    }

    public String getSuccesstext() {
        Reporter.log("Get text" + productsPrices.toString());
        CustomListeners.test.log(Status.PASS, "Success text" + successText);
        return getTextFromElement(successText);
    }

    public void clickShoppingCart() {
        clickOnElement(shoppingCartLink);
        Reporter.log("Click on " + shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "Shopping cart link" + shoppingCartLink);
    }

    public String getShoppingCartText() {
        Reporter.log("Get text" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, " text" + shoppingCartText);
        return getTextFromElement(shoppingCartText);
    }

    public String getMacbookNameText() {
        Reporter.log("Get text" + macbooknameText.toString());
        CustomListeners.test.log(Status.PASS, "Macbook name" + macbooknameText);
        return getTextFromElement(macbooknameText);
    }

    public void clearQty() {
        WebElement changeQuantity = driver.findElement(By.id("qty"));
        changeQuantity.sendKeys(Keys.DELETE);
        sendTextToElement(changeQty, "3");
        Reporter.log("Change quantity " + changeQty.toString());
        CustomListeners.test.log(Status.PASS, "Change quantity" + changeQty);


    }

    public void changeQty() {
        sendTextToElement(changeQty, "2");
        Reporter.log("Change qty" + changeQty.toString());
        CustomListeners.test.log(Status.PASS, "Qty" + changeQty);
    }

    public void clickUpdateTab() {
        clickOnElement(updatetab);
        Reporter.log("Click on " + updatetab.toString());
        CustomListeners.test.log(Status.PASS, "Macbook name" + updatetab);
    }

    public String getModifiedSuccessText() {
        Reporter.log("Get text" + modifiedSuccessText.toString());
        CustomListeners.test.log(Status.PASS, "Macbook name" + modifiedSuccessText);
        return getTextFromElement(modifiedSuccessText);
    }

    public String getTotaltext() {
        Reporter.log("Get text" + totalText.toString());
        CustomListeners.test.log(Status.PASS, "Total text" + totalText);
        return getTextFromElement(totalText);
    }

    public void clickCheckout() {
        clickOnElement(checkoutLink);
        Reporter.log("Click on " + checkoutLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on checkout " + checkoutLink);
    }

    public String getCheckoutText() {
        Reporter.log("Get text" + checkoutText.toString());
        CustomListeners.test.log(Status.PASS, "Checkout text" + checkoutText);
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        Reporter.log("Get text" + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "New customer" + newCustomerText);
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutButton() {
        clickOnElement(guestCheckoutButton);
        Reporter.log("Click on " + guestCheckoutButton.toString());
        CustomListeners.test.log(Status.PASS, "guest checkout button " + guestCheckoutButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueLink);
        Reporter.log("Click on " + checkoutLink.toString());
        CustomListeners.test.log(Status.PASS, "Macbook name" + continueLink);
    }
}
