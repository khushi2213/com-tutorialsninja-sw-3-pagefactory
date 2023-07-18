package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountOptions;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//li")
    List<WebElement> optionList;
    @CacheLookup
    @FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]")
    WebElement logoutOption;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerOption;

    public void clickOnMyAccountTab() {
        mouseHoverToElementAndClick(myAccountTab);
        Reporter.log("Click on " + myAccountTab.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" + myAccountTab);
    }

    public void clickOnMyAccountTabAgain() {
        mouseHoverToElementAndClick(myAccountOptions);
        Reporter.log("Click on " + myAccountOptions.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" + myAccountOptions);
    }
    public void clickLogout() {
        mouseHoverToElementAndClick(logoutOption);
        Reporter.log("Click on " +logoutOption.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" +logoutOption);
    }
    public void clickOnRegister() {
        mouseHoverToElementAndClick(registerOption);
        Reporter.log("Click on " +registerOption.toString());
    //    CustomListeners.test.log(Status.PASS, "Text" +registerOption);
    }

    public String getRegisterAccountText() {
        Reporter.log("Get text" + registerAccountText.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" + registerAccountText);
        return getTextFromElement(registerAccountText);
    }

    public String getReturningCustomerText() {
        Reporter.log("Get text" + returningCustomerText.toString());
   //     CustomListeners.test.log(Status.PASS, "Postcode" + returningCustomerText);
        return getTextFromElement(returningCustomerText);
    }

    /*
     * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
     * "option" of type string
     * 1.2 This method should click on the options whatever name is passed as parameter.
     * (Hint: Handle List of Element and Select options)
     */
    public void selectMyAccountOptions(String option) {

        List<WebElement> list = getListOfElements(optionList);
        try {
            for (WebElement options : list) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            list = getListOfElements(optionList);

        }

  //      CustomListeners.test.log(Status.PASS, "Select option " + option);
        Reporter.log("Select " + option + " from " + optionList.toString());
    }
}
