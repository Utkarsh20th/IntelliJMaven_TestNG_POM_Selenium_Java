package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage {
    WebDriver driver;

    public GoogleSearchpage(WebDriver driver){
        this.driver = driver;
    }

    By searchbox = By.xpath("//textarea[@title='Search']");
    By Search_btn = By.xpath("(//center/input[@aria-label='Google Search'])[1]");
    By Facebook_link = By.xpath("//*[text()='Facebook - log in or sign up']");

    public void searchgoogle(String Searchinput) {
        driver.findElement(searchbox).sendKeys(Searchinput);
//        driver.findElement(searchbox).sendKeys(Keys.ENTER);
        driver.findElement(Search_btn).click();
    }

    public void ClickFacebook() throws Exception {
        driver.findElement(Facebook_link).click();

        Thread.sleep(2000);
    }

}
