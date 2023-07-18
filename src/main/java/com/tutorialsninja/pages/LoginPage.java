package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id ="input-email")
    WebElement emailAddress ;
    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword ;
    @CacheLookup
    @FindBy(xpath ="//input[@value='Login']" )
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountText;



    public void enterEmailAddress(String emailId){
        sendTextToElement(emailAddress,emailId);
        Reporter.log("Enter email id" + emailId + " to eamil id field " + emailAddress.toString());
   //     CustomListeners.test.log(Status.PASS, "email" + emailId);

    }
    public void enterValidPassword(String password){
        sendTextToElement(enterPassword,"Tango456");
        Reporter.log("Enter password" + password + " to password field" + enterPassword.toString());
    //    CustomListeners.test.log(Status.PASS, "password" + password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        Reporter.log("Click on " + loginButton.toString());
   //     CustomListeners.test.log(Status.PASS, "login" +loginButton);
    }
    public String getMyAccountText(){
        Reporter.log("Get  Text" + myAccountText.toString());
    //    CustomListeners.test.log(Status.PASS, "Sorting descending" + myAccountText);
        return getTextFromElement(myAccountText);
    }
}
