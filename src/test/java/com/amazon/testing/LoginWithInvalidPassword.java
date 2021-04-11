package com.amazon.testing;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithInvalidPassword extends BaseTest {

    @Test
    public void LoginWithInvalidPassword(){
        homePage.open();
        homePage.closeChangeAddressPopup(logger);
        loginPage.open();
        loginPage.insertEmail("AHT.test0@gmail.com");
        loginPage.clickContinueButton();
        loginPage.insertPassword("Asdf123451212!");
        loginPage.clickSubmitButton();

        assertIncorrectPasswordMessage();

    }
    @Step("Check incorrect password message")
    private void assertIncorrectPasswordMessage(){
        logger.info("Verifying incorrect password message");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.')]")).isDisplayed());
    }


}
