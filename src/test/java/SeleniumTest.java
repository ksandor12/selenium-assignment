import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SeleniumTest {
    ChromeOptions options;
    WebDriverWait wait;
    WebDriver driver;
    String password = "Password_123";
    String user_email = "modelbasedtestingks@gmail.com";
    String username = "SELENIUM ASSIGNMENT";
    @BeforeEach
    public void init(){
        this.options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://pizzaforte.hu/hu");
    }
    @Test
    public void mainPageTest(){
        // WebElement accept_cookies = waitAndReturnElement("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
        // accept_cookies.click();
        try {
            MainPage mainpage = new MainPage(driver,wait);
            assertEquals("Pizza Forte", mainpage.checkMainPageLogo_Login_Title()); // main page verification
        } catch (Exception e) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(screenshot, new File("error.png"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            throw e;
        }
    }
    @Test
    public void loginTest(){
        try {
            MainPage mainpage = new MainPage(driver,wait);
            assertEquals("Pizza Forte", mainpage.checkMainPageLogo_Login_Title()); // main page verification
            mainpage.login(user_email,password);
            assertEquals(username, mainpage.getUsername()); // login verification
        } catch (Exception e) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(screenshot, new File("error.png"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            throw e;
        }
    }
    @Test
    public void loginAndChangeAddressTest(){
        try {
            MainPage mainpage = new MainPage(driver,wait);
            assertEquals("Pizza Forte", mainpage.checkMainPageLogo_Login_Title()); // main page verification

            mainpage.login(user_email,password);
            assertEquals(username, mainpage.getUsername()); // login verification

            AddressPage addresspage = new AddressPage(driver,wait);
            addresspage.changeAddress();

            UserPage userpage = new UserPage(driver,wait);
            assertEquals("1 ker., Anna utca 13 1 / 1",userpage.getAddress()); // address verification
        } catch (Exception e) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(screenshot, new File("error.png"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            throw e;
        }
    }
    @AfterEach
    public void tearDown(){

    driver.quit();
    }
}
