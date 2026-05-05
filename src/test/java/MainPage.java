import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page{
    public MainPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    public String checkMainPageLogo_Login_Title(){
        WebElement logo = waitAndReturnElementByXpath("//div[@class='nav-logo']//img[@class='nav-logo-icon']");
        WebElement login = waitAndReturnElementByXpath("//div[@class='nav']//button[@class='nav-logged-out-container-button']");
        return driver.getTitle();
    }
    public void login(String user, String password){
        WebElement profile = waitAndReturnElementByXpath("//nav[@class='menu']//button[@class='nav-logged-out-container-button']");
        profile.click();
        WebElement email_field = waitAndReturnElementByXpath("//input[@id='dropdownUsername']");
        WebElement password_field = waitAndReturnElementByXpath("//input[@id='dropdownPassword']");
        email_field.sendKeys(user);
        password_field.sendKeys(password);
        WebElement login_button = waitAndReturnElementByXpath("//button[@class='btn login-box-basic login-box-btn m-0']");
        login_button.click();
    }
    public String getUsername(){
        WebElement username = waitAndReturnElementByXpath("/html/body/app-root/div/div[1]/app-default-layout/div[1]/app-header/header/div/nav/div/div[1]/div[3]/div/div/div/div");
        return username.getText();
    }
}
