package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewEmployee {
    @FindBy(how = How.ID, using = "exampleInputEmail")
    WebElement email;
    @FindBy(how = How.ID, using = "exampleInputPassword")
    WebElement password;
    @FindBy(how = How.CSS, using = "body > div > div > div > div > div > div > div > div > form > button")
    WebElement login;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/ul/li[2]/a")
    WebElement pims;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/ul/li[2]/div[2]/a")
    WebElement newEmployees;
    @FindBy(how = How.ID, using = "employeeCode")
    WebElement employeeCode;
    @FindBy(how = How.ID, using = "employeeType")
    WebElement employeeType;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[2]/div[1]/div[3]/div/select/option[4]")
    WebElement employeeTypeDropDown;
    @FindBy(how = How.ID, using = "nameEnglish")
    WebElement name;
    @FindBy(how = How.ID, using = "motherNameEnglish")
    WebElement motherName;
    @FindBy(how = How.ID, using = "fatherNameEnglish")
    WebElement fathername;
    @FindBy(how = How.ID, using = "nationality")
    WebElement nationality;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[6]/div[1]/div/div/select/option[1]")
    WebElement nationalityDropDown;
    @FindBy(how = How.ID, using = "dateOfBirth")
    WebElement dob;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[8]/div[1]/div/div/select")
    WebElement placeOfBirth;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[8]/div[1]/div/div/select/option[15]")
    WebElement birthPlaceDropDown;
    @FindBy(how =  How.ID, using = "religion")
    WebElement religion;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[9]/div[1]/div/div/select/option[2]")
    WebElement religionDropDown;
    @FindBy(how = How.ID, using = "gender")
    WebElement gender;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[9]/div[2]/div/div/select/option[2]")
    WebElement genderDropDown;
    @FindBy(how = How.ID, using = "emailAddress")
    WebElement emailAddress;
    @FindBy(how = How.ID, using = "emailAddressPersonal")
    WebElement emailAddressPersonal;
    @FindBy(how = How.ID, using = "mobileNumberOffice")
    WebElement mobileNumberOffice;
    @FindBy(how = How.ID, using = "mobileNumberPersonal")
    WebElement mobileNumberPersonal;
    @FindBy(how = How.ID, using = "joiningDateGovtService")
    WebElement joiningDate;
    @FindBy(how = How.ID, using = "designation")
    WebElement post;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/div[19]/div[2]/div/div/select/option[6]")
    WebElement postDropDown;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div/div/div/div/div/form/button")
    WebElement submitButton;
    public void addNewEmployee(){
        email.sendKeys("admin");
        password.sendKeys("123456");
        login.click();
        pims.click();
        newEmployees.click();
        employeeCode.sendKeys("emp-111");
        employeeType.click();
        employeeTypeDropDown.click();
        name.sendKeys("abc");
        motherName.sendKeys("AbC");
        fathername.sendKeys("ABC");
        nationality.click();
        nationalityDropDown.click();
        dob.sendKeys("14-Sep-2001");
        placeOfBirth.click();
        birthPlaceDropDown.click();
        religion.click();
        religionDropDown.click();
        gender.click();
        genderDropDown.click();
        emailAddress.sendKeys("abc@gmail.com");
        emailAddressPersonal.sendKeys("ABC@gmail.com");
        mobileNumberOffice.sendKeys("12345678");
        mobileNumberPersonal.sendKeys("234567890");
        joiningDate.sendKeys("01-Sep-2021");
        post.click();
        postDropDown.click();
        submitButton.click();
    }
}
