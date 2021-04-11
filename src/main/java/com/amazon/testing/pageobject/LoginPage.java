package com.amazon.testing.pageobject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());


    private static final String LOGIN_PAGE_TITLE = PropertyManager.getProperty("loginpage.title");

    public static final By LOGIN_PAGE_CLICK = By.xpath("//*[contains(text(),'Hello, Sign in')]");
    public static final By EMAIL = new By.ById("ap_email");
    public static final By PASSWORD = new By.ById("ap_password");
    public static final By CONTINUE_BUTTON = new By.ById("continue");
    public static final By SUBMIT_BUTTON = new By.ById("signInSubmit");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open login page")
    public LoginPage open() {
        logger.info("Trying to open login page");
        clickOnElement(LOGIN_PAGE_CLICK, logger);
        checkPageTitle(LOGIN_PAGE_TITLE, logger);
        return this;
    }


    @Step("Insert Email")
    public LoginPage insertEmail(String email){
        logger.info("Inserting email");
        enterTextIntoField(EMAIL, email,logger);
        return this;
    }

    @Step("Insert Password")
    public LoginPage insertPassword(String password){
        logger.info("Inserting password");
        enterTextIntoField(PASSWORD, password,logger);
        return this;
    }

    @Step("Press Continue button")
    public LoginPage clickContinueButton(){
        logger.info("Click continue button");
        clickOnElement(CONTINUE_BUTTON, logger);
        return this;
    }

    @Step("Press Submit button")
    public LoginPage clickSubmitButton(){
        logger.info("Click continue button");
        clickOnElement(SUBMIT_BUTTON, logger);
        return this;
    }
}
