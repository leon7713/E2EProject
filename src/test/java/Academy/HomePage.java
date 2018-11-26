package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());


    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password,String text) throws IOException {
        driver.get(prop.getProperty("url"));
        LandingPage l = new LandingPage(driver);
        l.getLogin().click();

        LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        log.info(text);
        lp.getLogin().click();
    }


    @AfterTest
    public void tearDown() {
        driver.close();
        driver=null;
    }


    @DataProvider
    public Object[][] getData() {
        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[2][3];
        //0-th row
        data[0][0] = "nonrestricteduser@123.com";
        data[0][1] = "456";
        data[0][2] = "Non Restricted User";
        //1-th row
        data[1][0] = "restricteduser@123.com";
        data[1][1] = "789";
        data[1][2] = "Restricted User";

        return data;
    }

}
