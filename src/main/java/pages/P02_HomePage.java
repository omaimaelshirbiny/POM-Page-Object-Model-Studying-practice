package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class P02_HomePage {

    //elements
    private  WebDriver driver;
    private By logOutButton = By.xpath("/html/body/header/nav/button");

    //constructor from previous page (login page )
    public P02_HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //events
    public P01_LoginPage clickOnLogoutButton ()
    {
//        driver.findElement(logOutButton).click();
        Utility.clickOnButton(driver,logOutButton);
        return new P01_LoginPage(driver);
    }

}
