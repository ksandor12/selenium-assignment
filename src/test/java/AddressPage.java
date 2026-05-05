import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends Page{
    public AddressPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    //Choose city or street depending on index; 1 = city; 2 = street
    private void chooseFromDropdown(int div_index, String text){
        WebElement dropdown_narrow = waitAndReturnElementByXpath("//app-add-address//div[@class='row']//div["+div_index+"]//span[@class='ng-arrow-wrapper']");
        dropdown_narrow.click();
        WebElement dropdown_field = waitAndReturnElementByXpath("//app-add-address//div[@class='row']//div["+div_index+"]//input[@type='text']");
        dropdown_field.sendKeys(text);
        WebElement element_to_choose = waitAndReturnElementByXpath("//app-add-address//ng-dropdown-panel//span");
        element_to_choose.click();
    }
    private void inputAddressNumber(String number){
        WebElement address_number_field = waitAndReturnElementByXpath("//app-add-address//input[@id='address-number']");
        address_number_field.sendKeys(number);
    }
    private void inputFloorAndDoor(String floor_and_door){
        WebElement floor_and_door_field = waitAndReturnElementByXpath("//app-add-address//input[@id='address-door']");
        floor_and_door_field.sendKeys(floor_and_door);
    }
    private void inputRemark(String remark){
        WebElement floor_and_door_field = waitAndReturnElementByXpath("//app-add-address//input[@id='address-doorbell']");
        floor_and_door_field.sendKeys(remark);
    }

    public void changeAddress(){
        clickDropdownNextToUserProfile();
        WebElement newAddress = waitAndReturnElementByXpath("//app-header//app-dropdown-loggedin//a[@href='/hu/felhasznalo?panel=uj-cim']");
        newAddress.click();
        chooseFromDropdown(1,"Budapest, 1 ker");
        chooseFromDropdown(2,"Anna utca");
        inputAddressNumber("13");
        inputFloorAndDoor("1 / 1");
        inputRemark("megjegyzes");
        WebElement save_button = waitAndReturnElementByXpath("//app-add-address//div[@class='add-new-address']//button");
        save_button.click();
    }
}
