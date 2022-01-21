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
        log.info(">>>>>>>Contact details page has opened");
        return isExist(DETAILS_LINK);
    }

    public String getDetailsName() {
        return driver.findElement(By.xpath(String.format(nameDetailsLocator))).getText();
    }

    public String getDetailsAccountName(String fieldName) {
        log.info(">>>>>>>Get Details Account Name");
        return driver.findElement(By.xpath(String.format(accountNameDetailsLocator, fieldName))).getText();
    }

    public String getDetailsDepartment(String fieldName) {
        log.info(">>>>>>>Get Details Department");
        return driver.findElement(By.xpath(String.format(assistantDescDepartmentLocator, fieldName))).getText();
    }

    public String getDetailsContactInformation(String fieldName) {
        log.info(">>>>>>>Get Details Contact Information");
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsOtherInformation(String fieldName) {
        log.info(">>>>>>>Get Details Other Information");
        return driver.findElement(By.xpath(String.format(otherInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsEmail() {
        log.info(">>>>>>>Get Details Email");
        return driver.findElement(By.xpath(String.format(emailDetailsLocator))).getText();
    }

    public String getDetailsFax() {
        log.info(">>>>>>>Get Details Fax");
        return driver.findElement(By.xpath(String.format(faxDetailsLocator))).getText();
    }
    public String getDetailsPhone() {
        log.info(">>>>>>>Get Details Phone");
        return driver.findElement(By.xpath(String.format(phoneDetailsLocator))).getText();
    }

    public String getDetailsMobile() {
        log.info(">>>>>>>Get Details Mobile");
        return driver.findElement(By.xpath(String.format(mobileDetailsLocator))).getText();
    }

    public String getDetailsHomePhone(String fieldName) {
        log.info(">>>>>>>Get Details Home Phone");
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsOtherPhone(String fieldName) {
        log.info(">>>>>>>Get Details Other Phone");
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }

    public String getDetailsAsstPhone(String fieldName) {
        log.info(">>>>>>>Get Details Assistant Phone");
        return driver.findElement(By.xpath(String.format(contactInformationDetailsLocator, fieldName))).getText();
    }
    public String getDetailsAssistant(String fieldName) {
        log.info(">>>>>>>Get Details Assistant");
        return driver.findElement(By.xpath(String.format(assistantDescDepartmentLocator, fieldName))).getText();
    }

    public String getDetailsDesc(String fieldName) {
        log.info(">>>>>>>Get Details Description");
        return driver.findElement(By.xpath(String.format(assistantDescDepartmentLocator, fieldName))).getText();
    }


}
