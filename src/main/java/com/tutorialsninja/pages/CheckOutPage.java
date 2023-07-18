package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement emailField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephoneFeild;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement addressField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement cityField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcodeField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement countryField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement stateFiels;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonguestTab;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsandConditionBox;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonpaymentTab;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Warning: Payment method required!']")
    WebElement warningMessageText;
    @CacheLookup
    @FindBy(tagName = "textarea")
    WebElement textArea;

    public void enterFirstname(String name) {
        sendTextToElement(firstNameField, name);
        Reporter.log("Enter first name" +name + " to first name field " + firstNameField.toString());
 //       CustomListeners.test.log(Status.PASS, "First name" + name);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField,lastName);
        Reporter.log("Enter lastname" + lastName + " to lastname field " + lastName.toString());
     //   CustomListeners.test.log(Status.PASS, "Surname" + lastName);
    }

    public void enterEmail(String emailId) {
        sendTextToElement(emailField, emailId);
     Reporter.log("Enter Email id" + emailId + " to email field " + emailField.toString());
     //   CustomListeners.test.log(Status.PASS, "Email id " +emailId);
    }

    public void enterTelephone(String teleNumber) {
        sendTextToElement(telephoneFeild, teleNumber);
        Reporter.log("Enter phone number  " +telephoneFeild .toString());
     //   CustomListeners.test.log(Status.PASS, "Telephone number" + teleNumber);
    }

    public void enterAddress(String streetName) {
        sendTextToElement(addressField, streetName);
        Reporter.log("Enter street name" + streetName + " to street name field " +addressField.toString());
      //  CustomListeners.test.log(Status.PASS, "Street name" + streetName);
    }

    public void enterCity(String cityName) {
        sendTextToElement(cityField,cityName);
        Reporter.log("Enter city name" +cityName + " to city name field " +cityField.toString());
   //     CustomListeners.test.log(Status.PASS, "Cityname" + cityName);
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(postcodeField, postcode);
        Reporter.log("Enter postcode" +postcode + " to postcode field " +postcodeField.toString());
     //   CustomListeners.test.log(Status.PASS, "Postcode" + postcode);
    }

    public void enterCountry(String countryName) {
        sendTextToElement(countryField, countryName);
        Reporter.log("Enter country name" + countryName + " to country name field " +countryField.toString());
    //    CustomListeners.test.log(Status.PASS, "Country name" + countryName);
    }

    public void enterState(String stateName) {
        sendTextToElement(stateFiels,stateName);
        Reporter.log("Enter state name" +stateName + " to state field " +stateFiels.toString());
    //    CustomListeners.test.log(Status.PASS, "State name" +stateName);
    }

    public void clickContinueButtonguest() {
        clickOnElement(continueButtonguestTab);
        Reporter.log("Click on "  + continueButtonguestTab.toString());
    //    CustomListeners.test.log(Status.PASS, "Continue" + continueButtonguestTab);
    }

    public void enterCommentInTextAea(String text) {
        sendTextToElement(textArea, text);
        Reporter.log("Enter text" +text + " to text area field " +textArea.toString());
    //    CustomListeners.test.log(Status.PASS, "Text " + text);
    }

    public void checkTermsAndCondtionCheckBox() {
        clickOnElement(termsandConditionBox);
        Reporter.log(" Click on " +termsandConditionBox + " to term and condition box " +termsandConditionBox.toString());
   //     CustomListeners.test.log(Status.PASS, "Check the box" +termsandConditionBox);

    }

    public void clickContinueButtonpayment() {
        clickOnElement(continueButtonpaymentTab);
        Reporter.log("Click on "  + continueButtonpaymentTab.toString());
   //     CustomListeners.test.log(Status.PASS, "Click on " + continueButtonpaymentTab);
    }
    public String GetWarningMessageText() {
        Reporter.log("Get text " + warningMessageText.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" +warningMessageText);
        return getTextFromElement(warningMessageText);
    }
}
