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
    @FindBy(how = How.ID, using = "categoryId")
    WebElement categoryName;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[2]/div[1]/select/option[3]")
    WebElement drama;
    @FindBy(how = How.ID, using = "bookId")
    WebElement bookId;
    @FindBy(how = How.ID, using = "bookName")
    WebElement bookName;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/button")
    WebElement submit;
    @FindBy (how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    WebElement humanResources;

    public void books() {
        email.sendKeys("admin");
        password.sendKeys("123456");
        login.click();
        library.click();
        bookList.click();
        categoryName.click();
        drama.click();
        bookId.sendKeys("111");
        bookName.sendKeys("Hamza");
        submit.click();
    }
    public String name(){
        String actual = humanResources.getText();
        return actual;
    }
}
