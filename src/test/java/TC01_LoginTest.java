import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utilities.DataUtility;
import utilities.Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginTest {

    private WebDriver driver;
//    pages.P01_LoginPage loginPage ;
//    fake username variable
    String UserName = new Faker().name().username();
    String Password = new Faker().name().username();


    @BeforeMethod
    public void setUp () throws IOException {
        driver = new ChromeDriver();
        driver.get(DataUtility.getPropertyValue("environment","LOGIN_PAGE"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Description ("this test to verify that user logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("omaima")
    @Link (name = "explorer" , url = "www.google.com")
    @Issue("Trello.com")
    @TmsLink("Trello.com")
    @Epic("WEb test")
    @Feature("login")
    @Story("valid login")
    @Test
    public void validLoginTC () throws IOException {
        new P01_LoginPage(driver).enterUserName(DataUtility.getJsonData("loginData" , "userName"))
                .enterPassword(DataUtility.getJsonData("loginData" , "password"))
                .clickOnLoginButton();
        Utility.sendScreenshotToAllure(driver,"valid login tc");
        Assert.assertEquals(driver.getCurrentUrl(),DataUtility.getPropertyValue("environment","HOME_PAGE"));
    }

    @Test
    public void inValidLoginTC () throws IOException {
        new P01_LoginPage(driver).enterUserName(UserName)
                .enterPassword(Password)
                .clickOnLoginButton();
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),DataUtility.getPropertyValue("environment","HOME_PAGE"));
    }

    @AfterMethod
    public void quit ()
    {
        driver.quit();
    }

}
