package com.amazon.testing.pageobject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());
    private static final String PAGE_TITLE = "Amazon.com Shopping Cart";
    public static final By BASKET_PAGE_CLICK = new By.ById("nav-cart-count");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open basket page")
    public BasketPage openBasket() {
        logger.info("Trying basket page");
        clickOnElement(BASKET_PAGE_CLICK, logger);
        checkPageTitle(PAGE_TITLE, logger);
        return this;
    }

}
