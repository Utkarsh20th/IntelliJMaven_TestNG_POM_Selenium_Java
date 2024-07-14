package Objects;

import Test_Scenarios.TestMethods_GoogleSearch;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Facebookpage {
    WebDriver driver;
    WebDriverWait wait;
    TestMethods_GoogleSearch obj = new TestMethods_GoogleSearch();

    public Facebookpage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void takeScreenshot() {
        By blockedMessage = By.xpath("(//*[text()='You’re Temporarily Blocked'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(blockedMessage));

        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\joxbi\\IntelliJ_Projects\\IntelliJMaven_TestNG_POM_Selenium_Java\\test-output\\Screenshots\\Class_TestMethods_GoogleSearch\\"+obj.getClass().getSimpleName()+"_Screenshot_"+ DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss").format(LocalDateTime.now())+".jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
