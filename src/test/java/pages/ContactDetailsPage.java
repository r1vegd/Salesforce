package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {
    public static final By DETAILS_LINK = By.xpath("//a[@id='detailTab__item']");
    String nameDetailsLocator = "//slot[@slot='outputField']//lightning-formatted-name";
    String accountNameDetailsLocator = "//span[text()='%s']/ancestor::force-record-layout-row//a[@href]//span";
    String titleNDepartmentDetailsLocator = "//span[text()='%s']/ancestor::force-record-layout-item//lightning-formatted-text";
    String contactInformationDetailsLocator = "//span[text()='%s']/ancestor::force-record-layout-row//a[@href]";
    String emailDetailsLocator = "//span[text()='Email']/ancestor::force-record-layout-row//a[@class='emailuiFormattedEmail']";
    String faxDetailsLocator = "//span[text()='Fax']/ancestor::force-record-layout-row//a[@lightning-formattedphone_formattedphone]";

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ContactDetailsPage detailsTabOpen() {
        driver.findElement(DETAILS_LINK).click();
        return new ContactDetailsPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }

    public String getDetailsName() {
        return driver.findElement(By.xpath(String.format(nameDetailsLocator))).getText();
    }

    public String getDetailsAccountName(String fieldName) {
        return driver.findElement(By.xpath(String.format(accountNameDetailsLocator, fieldName))).getText();
    }

    public String getDetailsTitleNDepartment(String fieldName) {
        return driver.findElement(By.xpath(String.format(titleNDepartmentDetailsLocator, fieldName))).getText();
    }

    public String getDetailsContactInformation(String fieldName) {
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsEmail() {
        return driver.findElement(By.xpath(String.format(emailDetailsLocator))).getText();
    }

    public String getDetailsFax() {
        return driver.findElement(By.xpath(String.format(faxDetailsLocator))).getText();
    }


}
