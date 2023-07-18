package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(name = "firstname")
    WebElement firstNameField ;
    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastNameField ;
    @CacheLookup
    @FindBy(name = "email")
    WebElement emailField ;
    @CacheLookup
    @FindBy(name ="telephone" )
    WebElement telephoneField ;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField ;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField ;
    @CacheLookup
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    WebElement subscribeRadioButton;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountHasBeenCreatedText;
    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Continue']")
    WebElement clickContinueButton ;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink ;
    @CacheLookup
    @FindBy(xpath ="//h1[contains(text(),'Account Logout')]" )
    WebElement accountLogoutText ;
    public void enterFirstName(String firstName){
        sendTextToElement(firstNameField,firstName);
        Reporter.log("Enter First name" +firstName + " to firstname field " + firstNameField.toString());
    //    CustomListeners.test.log(Status.PASS, "Postcode" + firstName);

    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameField,lastName);
        Reporter.log("Enter lastname" +lastName + " to lastname field " + lastNameField.toString());
     //   CustomListeners.test.log(Status.PASS, "Postcode" + lastName);

    }
    public void enterEmail(String emailId){
        sendTextToElement(emailField,emailId);
        Reporter.log("Enter email " +emailId + " to email field " +emailField.toString());
    //    CustomListeners.test.log(Status.PASS, "Postcode" + emailId);

    }
    public void enterTelephone(String telephoneNumber){
        sendTextToElement(telephoneField,telephoneNumber);
        Reporter.log("Enter telephone number" +telephoneNumber+ " to telephone field " +telephoneField.toString());
     //   CustomListeners.test.log(Status.PASS, "Postcode" + telephoneNumber);


    }
    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password" +password + " to password field " +passwordField.toString());
    //    CustomListeners.test.log(Status.PASS, "Postcode" + password);

    }
    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordField, confirmPassword);
        Reporter.log("Enter password again " +confirmPassword + " to confirm password field field " +confirmPasswordField.toString());
     //   CustomListeners.test.log(Status.PASS, "Postcode" + confirmPassword);


    }
    public void selectSubscribeYesRadioButton(){
        clickOnElement(subscribeRadioButton);
        Reporter.log("Click on "  +subscribeRadioButton.toString());
     //   CustomListeners.test.log(Status.PASS, "Subscribe button " + subscribeRadioButton);


    }
    public void clickPrivacyPolicyCheckbox(){
        clickOnElement(privacyPolicyCheckBox);
        Reporter.log("Click on " +privacyPolicyCheckBox.toString());
  //      CustomListeners.test.log(Status.PASS, "Privacy policy checkbox" + privacyPolicyCheckBox);

    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
        Reporter.log("Click on " +continueButton.toString());
    //    CustomListeners.test.log(Status.PASS, "Postcode" + continueButton);


    }
    public String getAccountHasBeenCreatedText(){
        Reporter.log("Get text "  +accountHasBeenCreatedText.toString());
  //      CustomListeners.test.log(Status.PASS, "Account created" + accountHasBeenCreatedText);
        return getTextFromElement(accountHasBeenCreatedText);
    }
    public void clickOnContinueButtonAgain(){
        mouseHoverToElementAndClick(clickContinueButton);
        Reporter.log("Click on "  +clickContinueButton.toString());
   //     CustomListeners.test.log(Status.PASS, "Continue button" + clickContinueButton);
    }
    public void clickOnMyAccountLink(){
        clickOnElement(myAccountLink);
        Reporter.log("Click on " +myAccountLink.toString());
    //    CustomListeners.test.log(Status.PASS, "Click on account link " + myAccountLink);
    }
    public String getAccountLogoutText(){
        Reporter.log("Get text " +accountLogoutText.toString());
   //     CustomListeners.test.log(Status.PASS, "Logout text" +accountLogoutText);
        return getTextFromElement(accountLogoutText);
    }
}
