package com.amazon.testing;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithNoResultsFound extends BaseTest {

    @Test
    public void SearchWithNoResultsFound() {
        homePage.open();
        homePage.closeChangeAddressPopup(logger);
        homePage.selectSearchInItem("Baby", logger);
        homePage.insertSearchedText("asfrs dsgdf gdfg", logger);
        homePage.clickSearchButton();


        assertMessage();

    }

    @Step("Check item not found message")
    private void assertMessage(){
        logger.info("Verifying item not found message");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'No results for')]")).isDisplayed());
    }
}