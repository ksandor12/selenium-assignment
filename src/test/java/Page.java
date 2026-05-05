import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {
    protected WebDriverWait wait;
    protected WebDriver driver;
    public Page(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    protected WebElement waitAndReturnElementByXpath(String xpath) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this.driver.findElement(By.xpath(xpath));
    }
    protected void clickDropdownNextToUserProfile(){
        WebElement dropdownArrow = waitAndReturnElementByXpath("//div[@class='nav']//div[@class='nav-login-container']//img[@class='user-arrow-down']");
        dropdownArrow.click();
    }
}
