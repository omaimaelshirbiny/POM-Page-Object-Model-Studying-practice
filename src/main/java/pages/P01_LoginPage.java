package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class P01_LoginPage {

    //element
    private WebDriver driver ;
    private final By userName = By.id("inputUsername");
    private final By password = By.id("inputPassword");
    private final By clickButton = By.id("loginButton");


    //constructor
    public  P01_LoginPage (WebDriver driver)
    {
        this.driver = driver;
    }


    //actions
    public P01_LoginPage enterUserName(String userNameText)
    {
//        driver.findElement(userName).sendKeys(userNameText);
        Utility.sendData(driver,userName,userNameText);
        return this;
    }

    public P01_LoginPage enterPassword(String passwordText)
    {
//        driver.findElement(password).sendKeys(PasswordText);
        Utility.sendData(driver,password,passwordText);
        return this;
    }

    public P02_HomePage clickOnLoginButton ()
    {
//        driver.findElement(cliskButton).click();
        Utility.clickOnButton(driver,clickButton);
        return new P02_HomePage(driver);
    }
}
