package com.amazon.testing;

import com.amazon.testing.listeners.TestReporter;
import com.amazon.testing.listeners.TestResultsListener;
import com.amazon.testing.pageobject.DriverManager;
import com.amazon.testing.pageobject.HomePage;
import com.amazon.testing.pageobject.LoginPage;
import com.amazon.testing.pageobject.GiftCardsPage;
import com.amazon.testing.pageobject.EGiftPage;
import com.amazon.testing.pageobject.BasketPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    protected WebDriver driver;
    public static final Logger logger = LogManager.getLogger("");

    protected HomePage homePage = null;
    protected LoginPage loginPage = null;
    protected GiftCardsPage giftCardsPage = null;
    protected EGiftPage eGiftPage = null;
    protected BasketPage basketPage = null;
    protected DriverManager driverManager = null;

    @Parameters("browserName")
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName, ITestContext context){
        driverManager = new DriverManager();
        driver = driverManager.getDriver(browserName);
        context.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        giftCardsPage = new GiftCardsPage(driver);
        eGiftPage = new EGiftPage(driver);
        basketPage = new BasketPage(driver);
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
