package pageobjects;

import browserdriverssetup.BrowserDriverSetUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogOut {
    @FindBy(how = How.ID, using = "exampleInputEmail")
    WebElement email;
    @FindBy(how = How.ID, using = "exampleInputPassword")
    WebElement password;
    @FindBy(how = How.CSS, using = "body > div > div > div > div > div > div > div > div > form > button")
    WebElement login;
    @FindBy(how = How.ID, using = "userDropdown")
    WebElement dropDown;
    @FindBy(how = How.XPATH, using = "/html/body/nav/ul/li/div/a[2]/span")
    WebElement logOutButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[3]/form/button[2]")
    WebElement logOutProfile;

    public void loggingOut(){
        email.sendKeys("admin");
        password.sendKeys("123456");
        login.click();
        dropDown.click();
        logOutButton.click();
        logOutProfile.click();
    }
}
