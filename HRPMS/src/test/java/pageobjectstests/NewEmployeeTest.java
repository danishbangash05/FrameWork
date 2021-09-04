package pageobjectstests;

import browserdriverssetup.BrowserDriverSetUp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.NewEmployee;

public class NewEmployeeTest extends BrowserDriverSetUp {
    NewEmployee employee = null;

    @BeforeMethod
    public void initializeElements(){
        employee = PageFactory.initElements(driver, NewEmployee.class);
    }
    @Test
    public void LogInTest(){
        employee.addNewEmployee();
    }
}
