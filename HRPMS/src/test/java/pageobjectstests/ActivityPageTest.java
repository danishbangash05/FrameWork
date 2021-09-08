package pageobjectstests;

import browserdriverssetup.BrowserDriverSetUp;
import excelreader.DataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ActivityPage;

public class ActivityPageTest extends BrowserDriverSetUp {

    ActivityPage activityPage = null;

    @BeforeMethod
    public void initializeElements(){
        activityPage = PageFactory.initElements(driver, ActivityPage.class);
    }

    @DataProvider
    public Object[][] dataProvider() throws Exception {
        DataReader excelReader = new DataReader();
        //Where is the excel file
        excelReader.setExcelFile("/Users/danishbangash/Desktop/QA/FrameWork/HRPMS/excelreader/sample.xlsx");
        Object[][] data = excelReader.getExcelSheetData("Sheet0");
        return data;
    }

    @Test(dataProvider = "dataProvider")
    public void masterPmsTest(String status, String name)  {
        activityPage.logIn();
        activityPage.activityStatus(status,name);
        activityPage.save();
        String actual = activityPage.num();
        Assert.assertEquals(actual, "1");

    }

}
