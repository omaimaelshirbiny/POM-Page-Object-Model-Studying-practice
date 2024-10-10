package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Utility {

    private static String screenPath = ("test-outputs/screenShoots/");

    /**
    * Utility function click on element to help find element
    * then explicit wait then click on it
    * @param driver
    * @Param locator
     * @return return void
     */

    //    TODO: Clicking on Element
    public static void clickOnButton (WebDriver driver , By locator)
    {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(locator));
        driver.findElement(locator).click();

    }


    //    TODO: Send Data ToElement
    public static void sendData (WebDriver driver , By locator , String sendText)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(sendText);
    }

    // TODO: Send screenshot in a report
    public static void sendScreenshotToAllure (WebDriver driver , String screenName) throws IOException {
        File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenDest = new File(screenPath + screenName + ".png");
        FileUtils.copyFile(screenSrc,screenDest);
        Allure.addAttachment(screenName, Files.newInputStream(Path.of(screenDest.getPath())));

    }
}
