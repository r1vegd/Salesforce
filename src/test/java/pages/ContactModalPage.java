package pages;

import elements.Dropdown;
import elements.Input;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {
    public static final By MODAL_TITLE = By.xpath("//h2[@class='slds-modal__title slds-hyphenate slds-text-heading--medium']");
    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    public ContactDetailsPage create(Contact contact) {
        new Dropdown(driver, "None").selectContactDropdown(contact.getSalutation());
        new Input(driver, "firstName").writeContact(contact.getFirstName());
        new Input(driver, "middleName").writeContact(contact.getMiddleName());
        new Input(driver, "lastName").writeContact(contact.getLastName());
        new Input(driver, "suffix").writeContact(contact.getSuffix());
        new Dropdown(driver, "Search Accounts...").selectContactDropdown(contact.getAccountName());
        new Input(driver, "Title").writeContact(contact.getTitle());
        new Input(driver, "Email").writeContact(contact.getEmail());
        new Input(driver, "Phone").writeContact(contact.getPhone());
        new Input(driver, "MobilePhone").writeContact(contact.getMobile());
        new Input(driver, "Department").writeContact(contact.getDepartment());
        new Input(driver, "Fax").writeContact(contact.getFax());
        new Input(driver, "street").writeAddress(contact.getMailingStreet());
        new Input(driver, "city").writeContact(contact.getMailingCity());
        new Input(driver, "postalCode").writeContact(contact.getMailingPostalCode());
        new Input(driver, "province").writeContact(contact.getMailingState());
        new Input(driver, "country").writeContact(contact.getMailingCountry());

        return clickSave();
    }

    public ContactDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
    }

}
