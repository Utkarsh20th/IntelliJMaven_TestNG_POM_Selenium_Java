package Test_Scenarios;

import Objects.Facebookpage;
import Objects.GoogleSearchpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMethods_GoogleSearch {
    WebDriver driver;
    WebDriverWait wait;
    GoogleSearchpage page;
    Facebookpage fb;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        this.driver = driver;
        page = new GoogleSearchpage(driver);
        fb = new Facebookpage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void SearchOperation() throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        page.searchgoogle("facebook");

        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void VerifyandAccessFacebook() throws Exception{
        page.ClickFacebook();
    }

    @Test(priority = 2)
    public void ZTakingScreenshot() {
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(driver.getCurrentUrl().contains("login"));

        if(driver.getCurrentUrl().contains("login")){
            fb.takeScreenshot();
        }
    }

    @AfterClass
    public void aftertest() {
        driver.quit();
    }
}
