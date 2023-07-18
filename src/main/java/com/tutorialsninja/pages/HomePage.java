package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops" )
    WebElement mouseHoverDesktop ;
    @CacheLookup
    @FindBy(linkText ="Laptops & Notebooks" )
    WebElement mouseHoverLaptopsAndNotebooks ;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement mouseHoverComponents ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopNotebookText ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;

    public void mouseHoverAndClickDesktops() {
        mouseHoverToElementAndClick(mouseHoverDesktop);
    }
    public void mouseHoverAndClickLaptopsAndNotebooks(){
        mouseHoverToElementAndClick(mouseHoverLaptopsAndNotebooks);
    }
    public void mouseHoverAndClickComponents(){
        mouseHoverToElementAndClick(mouseHoverComponents);
    }

    public void selectMenu(String menu) {
    //    CustomListeners.test.log(Status.PASS,"Select option " + menu);
        Reporter.log("Select " +menu +" from " + topMenu.toString());
        try {
            List<WebElement> topMenuList = topMenu;
            for (WebElement listOfElement : topMenuList) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> topMenuList = topMenu;
        }

    }
    public String getDesktopText(){
        Reporter.log("Get Text"  + desktopText.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" +desktopText);
        return getTextFromElement(desktopText);
    }

    public String getLaptopsNotebooksText(){
        Reporter.log("Get Text"  +laptopNotebookText.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" +laptopNotebookText);
        return getTextFromElement(laptopNotebookText);
    }
    public String getComponents(){
        Reporter.log("Get Text"  + componentsText.toString());
   //     CustomListeners.test.log(Status.PASS, "Text" +componentsText);
        return getTextFromElement(componentsText);
    }

}
