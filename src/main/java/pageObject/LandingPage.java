package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class LandingPage {
    public WebDriver driver;

    By signin = By.xpath("//i[@class = \"fa fa-lock fa-lg\"]");
    By title = By.xpath("//div[@class = \"text-center\"]/h2[text() = \"Featured Courses\"]");
    By navbar = By.xpath("//ul[@class = \"nav navbar-nav navbar-right\"]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin() { return driver.findElement(signin); }
    public WebElement getTitle() {
        return driver.findElement(title);
    }
    public WebElement getNavbar() {
        return driver.findElement(navbar);
    }

}
