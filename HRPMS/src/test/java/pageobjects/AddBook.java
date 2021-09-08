package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddBook {
    @FindBy(how = How.ID, using = "exampleInputEmail")
    WebElement email;
    @FindBy(how = How.ID, using = "exampleInputPassword")
    WebElement password;
    @FindBy(how = How.CSS, using = "body > div > div > div > div > div > div > div > div > form > button")
    WebElement login;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/ul/li[5]/a")
    WebElement library;
    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div/div[1]/div/ul/li[5]/div[1]/a/span")
    WebElement bookList;

    public void books() {
        email.sendKeys("admin");
        password.sendKeys("123456");
        login.click();
        library.click();
        bookList.click();
    }
}
