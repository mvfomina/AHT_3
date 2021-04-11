package com.amazon.testing;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEGiftCardToBasket extends BaseTest {

    @Test
    public void AddEGiftCardToBasket(){
        homePage.open();
        homePage.closeChangeAddressPopup(logger);
        giftCardsPage.open();
        eGiftPage.open();
        eGiftPage.insertEmail("mvfomina@ukr.net");
        eGiftPage.addToBasket();
        basketPage.openBasket();
        assertCorrectAddingToBasket();

    }
    @Step("Check correct adding to basket")
    private void assertCorrectAddingToBasket(){
        logger.info("Check correct adding to basket");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'mvfomina@ukr.net')]")).isDisplayed());
    }


}