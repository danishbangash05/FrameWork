package pageobjectstests;

import browserdriverssetup.BrowserDriverSetUp;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddBook;

public class AddBookTest extends BrowserDriverSetUp {
    AddBook addBook = null;

    @BeforeMethod
    public void initializeElements(){
        addBook = PageFactory.initElements(driver, AddBook.class);
    }
    @Test
    public void LogInTest(){
        addBook.books();
        String act = addBook.name();
        Assert.assertEquals(act, "Hamzi");
    }
}
