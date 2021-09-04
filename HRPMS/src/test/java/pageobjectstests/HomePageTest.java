package pageobjectstests;

import browserdriverssetup.BrowserDriverSetUp;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class HomePageTest extends BrowserDriverSetUp {
    HomePage homePage = null;

    @BeforeMethod
    public void initializeElements(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    @Test
    public void LogInTest(){
        homePage.logIn();
    }
    public void bannerTest(){
        homePage.logIn();
        String actualValue = homePage.findBanner();
        String expectedValue = "Izaan Human Resources Management System";
        Assert.assertEquals(actualValue, expectedValue);
    }
}
