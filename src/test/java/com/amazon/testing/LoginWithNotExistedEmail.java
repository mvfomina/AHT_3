package com.amazon.testing;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithNotExistedEmail extends BaseTest {

    @Test
    public void LoginWithNotExistedEmail(){
        homePage.open();
        homePage.closeChangeAddressPopup(logger);
        loginPage.open();
        loginPage.insertEmail("AHT.test025235235@gmail.com");
        loginPage.clickContinueButton();

        assertIncorrectEmailMessage();

    }
    @Step("Check incorrect email")
    private void assertIncorrectEmailMessage(){
        logger.info("Verifying incorrect email message");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'We cannot find an account with that email address')]")).isDisplayed());
    }
}