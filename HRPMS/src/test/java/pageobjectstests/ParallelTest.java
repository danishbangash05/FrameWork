package pageobjectstests;

import browserdriverssetup.BrowserDriverSetUp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.NewEmployee;

public class ParallelTest extends BrowserDriverSetUp {
    HomePage homePage = null;
    NewEmployee employee = null;

    @BeforeMethod
    public void initializeElements() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        employee = PageFactory.initElements(driver, NewEmployee.class);
    }
}
//    @Test
////    public void LogInTest(){
//        employee.addNewEmployee();
//    }
//    @Test
////    public void LogInTest(){
//        homePage.logIn();
//    }
//    }
