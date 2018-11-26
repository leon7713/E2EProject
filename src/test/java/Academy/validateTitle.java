package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

import java.io.IOException;


public class validateTitle extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
        log.info("Driver is initialised");
        driver.get(prop.getProperty("url"));
        log.info("Navigate to Home page");
    }

    @Test
    public void basePageNavigation() throws IOException {
        LandingPage l = new LandingPage(driver);
        Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
        log.info("Successfully validated text message");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver=null;
    }

}
