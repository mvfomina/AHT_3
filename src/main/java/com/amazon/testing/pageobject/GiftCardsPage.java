package com.amazon.testing.pageobject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCardsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());

    private static final String GIFT_CARDS_PAGE_TITLE = "Amazon.com Gift Cards";
    public static final By GIFT_CARDS_PAGE_CLICK = By.xpath("//*[contains(text(),'Gift Cards')]");

    public GiftCardsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open eGift page")
    public GiftCardsPage open() {
        logger.info("Trying to open gift cards page");
        clickOnElement(GIFT_CARDS_PAGE_CLICK, logger);
        checkPageTitle(GIFT_CARDS_PAGE_TITLE, logger);
        return this;
    }

}
