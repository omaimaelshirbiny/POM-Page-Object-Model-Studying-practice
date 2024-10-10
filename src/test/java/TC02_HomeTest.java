import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utilities.DataUtility;

import java.io.FileNotFoundException;
import java.time.Duration;

public class TC02_HomeTest {

    private WebDriver driver;
//    pages.P01_LoginPage loginPage ;


    @BeforeMethod
    public void setUp ()
    {
        driver = new ChromeDriver();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void validLogoutTC () throws FileNotFoundException {
        new P01_LoginPage(driver).enterUserName(DataUtility.getJsonData("loginData","userName"))
                .enterPassword(DataUtility.getJsonData("loginData","password"))
                .clickOnLoginButton()
                .clickOnLogoutButton()
                .enterPassword(DataUtility.getJsonData("loginData","password"))
                .enterUserName(DataUtility.getJsonData("loginData","userName"))
                .clickOnLoginButton()
                .clickOnLogoutButton();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @AfterMethod
    public void quit ()
    {
        driver.quit();
    }

}
