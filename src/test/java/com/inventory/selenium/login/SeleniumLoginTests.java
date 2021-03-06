package com.inventory.selenium.login;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SeleniumExtension.class)
public class SeleniumLoginTests {

    private final ChromeDriver driver;

    public SeleniumLoginTests(ChromeDriver driver) {
        this.driver = driver;

        DesiredCapabilities decap = new DesiredCapabilities();
        decap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                UnexpectedAlertBehaviour.IGNORE);

        System.setProperty("sel.jup.screenshot.at.the.end.of.tests", "whenfailure");
        System.setProperty("sel.jup.screenshot.format", "png");
        System.setProperty("sel.jup.output.folder", "./src/test/onFailureScreenshots");
    }

    @BeforeEach
    public void setupPage(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.get("http://localhost:8080/");
            driver.manage().window().maximize();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginButton\"]/button")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    void add_login_test() throws InterruptedException {
        Thread.sleep(500);
        WebElement Email = driver.findElementByXPath("//*[@id=\"floatingInput\"]");
        Email.sendKeys("Email@gmail.com");

        Thread.sleep(500);
        WebElement Password = driver.findElementByXPath("//*[@id=\"floatingPassword\"]");
        Password.sendKeys("admin");

        Thread.sleep(500);
        WebElement login = driver.findElementByXPath("//*[@id=\"loginButton\"]");
        login.click();

        Thread.sleep(1000);
        // located element with contains()
        WebElement logout = driver.findElementByXPath("//*[@id=\"logoutButton\"]");
        logout.click();

        Thread.sleep(500);

        driver.quit();
    }
    @Test
    public void search_product_test() throws InterruptedException {
        Thread.sleep(5000);//*[@id="app"]/div/div/div[1]/ul/div[1]/a
        
        WebElement options = driver.findElementByXPath("//*[@id='app']/div/div/div[1]/ul/div[1]/a");
        options.click();
        Thread.sleep(5000);
        WebElement username = driver.findElementByXPath("//*[@id='floatingInput']");
        username.sendKeys("userNam");
        WebElement password = driver.findElementByXPath("//*[@id='floatingPassword']");
        password.sendKeys("123456");
        WebElement enter = driver.findElementByXPath("//*[@id='loginButton']");
        enter.click();
        Thread.sleep(5000);


        WebElement searchIn = driver.findElementByXPath("//*[@id='myInput']");
        searchIn.sendKeys("pepsi");
        Thread.sleep(5000);

        driver.close();
    }

    @Test
    public void filter_product_test() throws InterruptedException {
        Thread.sleep(5000);//*[@id="app"]/div/div/div[1]/ul/div[1]/a
        
        WebElement options = driver.findElementByXPath("//*[@id='app']/div/div/div[1]/ul/div[1]/a");
        options.click();
        Thread.sleep(5000);
        WebElement username = driver.findElementByXPath("//*[@id='floatingInput']");
        username.sendKeys("userNam");
        WebElement password = driver.findElementByXPath("//*[@id='floatingPassword']");
        password.sendKeys("123456");
        WebElement enter = driver.findElementByXPath("//*[@id='loginButton']");
        enter.click();
        Thread.sleep(5000);


        WebElement productcolo = driver.findElementByXPath("//*[@id='myTable']/thead/tr/th[3]");
        productcolo.click();
        Thread.sleep(5000);

        driver.close();
    }
}
