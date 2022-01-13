package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactDetailsPage extends BasePage {
    public static final By DETAILS_LINK = By.xpath("//a[@id='detailTab__item']");
    String nameDetailsLocator = "//slot[@slot='outputField']//lightning-formatted-name";
    String accountNameDetailsLocator = "//span[text()='%s']/ancestor::force-record-layout-row//a[@href]//span";
    String contactInformationDetailsLocator = "(//span[text()='%s']/ancestor::force-record-layout-row//a[@href])[1]";
    String otherInformationDetailsLocator = "(//span[text()='%s']/ancestor::force-record-layout-row//a[@href])[2]";
    String phoneDetailsLocator = "(//span[text()='Phone']/ancestor::force-record-layout-row//a[@href])[2]";
    String mobileDetailsLocator = "//span[text()='Mobile']/ancestor::force-record-layout-row//a[@lightning-formattedphone_formattedphone]";
    String emailDetailsLocator = "//span[text()='Email']/ancestor::force-record-layout-row//a[@class='emailuiFormattedEmail']";
    String faxDetailsLocator = "//span[text()='Fax']/ancestor::force-record-layout-row//a[@lightning-formattedphone_formattedphone]";
    String assistantDescDepartmentLocator = "(//span[text()='%s']/ancestor::force-record-layout-row//lightning-formatted-text)[1]";

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

    public String getDetailsDepartment(String fieldName) {
        return driver.findElement(By.xpath(String.format(assistantDescDepartmentLocator, fieldName))).getText();
    }

    public String getDetailsContactInformation(String fieldName) {
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsOtherInformation(String fieldName) {
        return driver.findElement(By.xpath(String.format(otherInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsEmail() {
        return driver.findElement(By.xpath(String.format(emailDetailsLocator))).getText();
    }

    public String getDetailsFax() {
        return driver.findElement(By.xpath(String.format(faxDetailsLocator))).getText();
    }
    public String getDetailsPhone() {
        return driver.findElement(By.xpath(String.format(phoneDetailsLocator))).getText();
    }

    public String getDetailsMobile() {
        return driver.findElement(By.xpath(String.format(mobileDetailsLocator))).getText();
    }

    public String getDetailsHomePhone(String fieldName) {
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsOtherPhone(String fieldName) {
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsAsstPhone(String fieldName) {
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }
    public String getDetailsAssistant(String fieldName) {
        return driver.findElement(By.xpath(String.format(assistantDescDepartmentLocator, fieldName))).getText();
    }

    public String getDetailsDesc(String fieldName) {
        return driver.findElement(By.xpath(String.format(assistantDescDepartmentLocator, fieldName))).getText();
    }


}
