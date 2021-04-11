package com.amazon.testing.pageobject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EGiftPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());
    private static final String PAGE_TITLE = "Amazon.com: Amazon eGift Card - Birthday Cupcakes: Gift Cards";
    public static final By EGIFT_PAGE_CLICK = By.xpath("//*[@alt=\"eGift\"]");
    public static final By EMAIL = new By.ById("gc-order-form-recipients");
    public static final By ADD_TO_BASKET_BUTTON = By.xpath("//*[@id=\"gc-buy-box-atc\"]");

    public EGiftPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open eGift page")
    public EGiftPage open() {
        logger.info("Trying to open gift cards page");
        clickOnElement(EGIFT_PAGE_CLICK, logger);
        checkPageTitle(PAGE_TITLE, logger);
        return this;
    }

    @Step("Insert Email")
    public EGiftPage insertEmail(String email){
        logger.info("Inserting email");
        enterTextIntoField(EMAIL, email,logger);
        return this;
    }

    @Step("Press Add to basket button")
    public EGiftPage addToBasket(){
        logger.info("Click add to basket button");
        clickOnElement(ADD_TO_BASKET_BUTTON, logger);
        return this;
    }
}
