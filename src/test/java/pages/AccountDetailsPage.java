package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {
    public static final By DETAILS_LINK = By.xpath("//a[@id='detailTab__item']");
    String fieldValue = "//records-lwc-detail-panel//span[text()='%s']/ancestor::force-record-layout-item//lightning-formatted-text";
    String websiteDetailsLocator = "(//lightning-formatted-url//a[contains(@href, 'https')])[1]";
    String parentAccountDetailsLocator = "//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']//a[@class='flex-wrap-ie11']//span";
    String phoneDetailsLocator = "(//a[@lightning-formattedphone_formattedphone])[1]";
    String employeesDetailsLocator = "//lightning-formatted-number[@lightning-formattednumber_formattednumber-host]";
    String fieldAddressValue = "//div//span[text()='%s']/ancestor::div[@force-recordlayoutitem_recordlayoutitem]//a";


    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage detailsTabOpen() {
        driver.findElement(DETAILS_LINK).click();
        return new AccountDetailsPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }

    public String getFiledValueByName(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }

    public String getDetailsWebsite() {
        return driver.findElement(By.xpath(String.format(websiteDetailsLocator))).getText();
    }

    public String getDetailsParentAccount() {
        return driver.findElement(By.xpath(String.format(parentAccountDetailsLocator))).getText();
    }

    public String getDetailsPhone() {
        return driver.findElement(By.xpath(String.format(phoneDetailsLocator))).getText();
    }

    public String getDetailsEmployees() {
        return driver.findElement(By.xpath(String.format(employeesDetailsLocator))).getText();
    }

    public String getFieldAddressValue(String fieldAddress) {
        return driver.findElement(By.xpath(String.format(fieldAddressValue, fieldAddress))).getText();
    }
}
