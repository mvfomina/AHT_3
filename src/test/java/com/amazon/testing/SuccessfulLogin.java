package com.amazon.testing;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLogin extends BaseTest {

    @Test
    public void LoginWithInvalidPassword(){
        homePage.open();
        homePage.closeChangeAddressPopup(logger);
        loginPage.open();
        loginPage.insertEmail("AHT.test0@gmail.com");
        loginPage.clickContinueButton();
        loginPage.insertPassword("Asdf12345!");
        loginPage.clickSubmitButton();

        assertCorrectLogin();

    }
    @Step("Check correct login")
    private void assertCorrectLogin(){
        logger.info("Verifying correct login");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'To continue, approve the notification sent to:')]")).isDisplayed());
    }


}