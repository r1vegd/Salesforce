package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {
    public static final By DETAILS_LINK = By.xpath("//a[@id='detailTab__item']");
    String fieldValue = "//records-lwc-detail-panel//span[text()='%s']/ancestor::force-record-layout-item//lightning-formatted-text";
    String websiteDetailsLocator = "(//lightning-formatted-url//a[contains(@href, 'https')])[1]";
    String parentAccountDetailsLocator = "//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']//a[@class='flex-wrap-ie11']//span";
    String phoneDetailsLocator = "(//a[@lightning-formattedphone_formattedphone])[2]";
    String employeesDetailsLocator = "//lightning-formatted-number[@lightning-formattednumber_formattednumber-host]";
    String fieldAddressValue = "//div//span[text()='%s']/ancestor::div[@force-recordlayoutitem_recordlayoutitem]//a";
    String faxDetailsLocator = "(//a[@lightning-formattedphone_formattedphone])[3]";
    String annualRevenueDetailsLocator = "//button[@title='Edit Annual Revenue']/ancestor::div[@class='slds-form-element__control']//lightning-formatted-text";


    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AccountDetailsPage detailsTabOpen() {
        driver.findElement(DETAILS_LINK).click();
        return new AccountDetailsPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        log.info(">>>>>>>Account details page has opened");
        return isExist(DETAILS_LINK);
    }

    public String getFiledValueByName(String fieldName) {
        log.info(String.format(">>>>>>>Get from %s field", fieldName));
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }

    public String getDetailsWebsite() {
        log.info(">>>>>>>Get Details Website");
        return driver.findElement(By.xpath(String.format(websiteDetailsLocator))).getText();
    }

    public String getDetailsParentAccount() {
        log.info(">>>>>>>Get Details Parent Accout");
        return driver.findElement(By.xpath(String.format(parentAccountDetailsLocator))).getText();
    }

    public String getDetailsPhone() {
        log.info(">>>>>>>Get Details Phone");
        return driver.findElement(By.xpath(String.format(phoneDetailsLocator))).getText();
    }

    public String getDetailsEmployees() {
        log.info(">>>>>>>Get Details Employees");
        return driver.findElement(By.xpath(String.format(employeesDetailsLocator))).getText();
    }

    public String getFieldAddressValue(String fieldAddress) {
        log.info(String.format(">>>>>>>Get %s from address field", fieldAddress));
        return driver.findElement(By.xpath(String.format(fieldAddressValue, fieldAddress))).getText();
    }

    public String getDetailsFax() {
        log.info(">>>>>>>Get Details Fax");
        return driver.findElement(By.xpath(String.format(faxDetailsLocator))).getText();
    }

    public String getDetailsAnnualRevenue() {
        log.info(">>>>>>>Get Details Annual Revenue");
        return driver.findElement(By.xpath(String.format(annualRevenueDetailsLocator))).getText();
    }

}
