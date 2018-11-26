package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.base;

import java.io.IOException;

public class validateNavigationBar extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());


    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation() throws IOException {
        LandingPage l = new LandingPage(driver);
        Assert.assertTrue(l.getNavbar().isDisplayed());
        log.info("Navigation bar is displayed");

    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver=null;
    }

}
