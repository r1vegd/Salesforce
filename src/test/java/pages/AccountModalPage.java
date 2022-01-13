package pages;

import elements.Dropdown;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountModalPage extends BasePage {
    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'inlineTitle')]");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public AccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    public AccountDetailsPage create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Dropdown(driver, "Parent Account").selectParentAccount(account.getParentAccount());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Dropdown(driver, "Type").selectOption(account.getType());
        new Dropdown(driver, "Industry").selectOption(account.getIndustry());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver, "Description").writeDescription(account.getDescription());
        new Input(driver, "Billing Street").writeBillingStreet(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingPostalCode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Input(driver, "Shipping Street").writeShippingStreet(account.getShippingStreet());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingState());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingPostalCode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());

        return clickSave();
    }

    public AccountDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }


}
