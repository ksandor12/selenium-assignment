import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage extends Page{
    public UserPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    public String getAddress(){
        clickDropdownNextToUserProfile();
        WebElement settings_button = waitAndReturnElementByXpath("//app-dropdown-loggedin//a[@href='/hu/felhasznalo']");
        settings_button.click();
        WebElement address_field = waitAndReturnElementByXpath("//app-address-select//span[@class='ng-value-label ng-star-inserted']");
        return address_field.getText();
    }
}
