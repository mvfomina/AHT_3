package com.amazon.testing.pageobject;


import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.testing.actions.Elements.findElementWithWait;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private static final String HOME_PAGE_URL = PropertyManager.getProperty("homepage.url");
    private static final String PAGE_TITLE = PropertyManager.getProperty("homepage.title");
    public static final By DROPDOWN_OPEN = By.xpath("//*[@id=\"searchDropdownBox\"]");
    public static final By DROPDOWN_SEARCH_ITEM = new By.ById("searchDropdownBox");
    public static final By SEARCH_TEXT = new By.ById("twotabsearchtextbox");
    public static final By SEARCH_BUTTON = new By.ById("nav-search-submit-button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open application home page")
    public HomePage open(){
        logger.info("Trying to open application home page");
        openWebPage(HOME_PAGE_URL, logger);
        checkPageTitle(PAGE_TITLE, logger);
        return this;
    }

    @Step("Closing Change Address popup")
    public void closeChangeAddressPopup(Logger logger) {
        logger.info("Closing Change Address popup");
        findElementWithWait(By.xpath("//*[@data-action-type=\"DISMISS\"]"),driver,logger).click();
    }

    @Step("Select item from Search In dropdown")
    public HomePage selectSearchInItem(String searchItem, Logger logger) {
        logger.info("Selecting item from Search In dropdown");
        driver.findElement(DROPDOWN_OPEN).click();
        driver.findElement(DROPDOWN_SEARCH_ITEM).sendKeys(searchItem);
        return this;
    }

    @Step("Insert searched text")
    public HomePage insertSearchedText(String searchedText, Logger logger){
        logger.info("Inserting searched text");
        enterTextIntoField(SEARCH_TEXT, searchedText, logger);
        return this;
    }
    @Step("Press Search button")
    public HomePage clickSearchButton(){
        logger.info("Click search button");
        clickOnElement(SEARCH_BUTTON, logger);
        return this;
    }

}
