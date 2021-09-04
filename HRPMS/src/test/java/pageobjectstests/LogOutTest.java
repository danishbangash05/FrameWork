package pageobjectstests;

import browserdriverssetup.BrowserDriverSetUp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LogOut;

public class LogOutTest extends BrowserDriverSetUp {
    LogOut logOut = null;
    @BeforeMethod
    public void initializeElements(){
        logOut = PageFactory.initElements(driver, LogOut.class);
    }
    @Test
    public void logOutTest(){
        logOut.logOut();
    }
}
