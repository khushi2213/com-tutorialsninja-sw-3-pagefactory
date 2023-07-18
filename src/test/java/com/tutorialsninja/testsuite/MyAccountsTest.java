package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.UUID;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {
    String email;
    MyAccountPage myAccountPage;
    RegisterPage registerPage ;
    LoginPage loginPage ;
    HomePage homePage ;

    @BeforeMethod(alwaysRun = true)

    public void inIt() {
        myAccountPage = new MyAccountPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        myAccountPage.getRegisterAccountText();
        String expectedMessage = "Register Account";
        String actualMessage = registerPage.getTextFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        String expectedMessage = "Returning Customer";
        String actualMessage = loginPage.getTextFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String option = "Register";
        myAccountPage.selectMyAccountOptions(option);
        registerPage.enterFirstName("Khushi");
        registerPage.enterLastName("Mishra");
        registerPage.enterEmail("khushi1233@gmail.com");
        registerPage.enterTelephone("0744667788");
        registerPage.enterPassword("Khushi@123");
        registerPage.enterConfirmPassword("Khushi@123");
        registerPage.selectSubscribeYesRadioButton();
        registerPage.acceptAlert();
        registerPage.clickOnContinueButton();

        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = registerPage.getAccountHasBeenCreatedText();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getTextFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        String option = "Login";
        myAccountPage.selectMyAccountOptions(option);
        loginPage.enterEmailAddress("khushi1234@gmail.com");
        loginPage.enterValidPassword("Khushi@123");
        loginPage.clickOnLoginButton();
        String expectedMessage = "My Account";
        String actualMessage = homePage.getTextFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        myAccountPage.selectMyAccountOptions(option);

        expectedMessage = "Account Logout";
        actualMessage = homePage.getTextFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
