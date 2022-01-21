package pages;

import elements.Dropdown;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info(">>>>>>>Filling new contact data");
        new Dropdown(driver, "None").selectContactDropdown(contact.getSalutation());
        new Input(driver, "firstName").writeContact(contact.getFirstName());
        new Input(driver, "lastName").writeContact(contact.getLastName());
        new Dropdown(driver, "Search Accounts...").selectContactDropdown(contact.getAccountName());
        new Input(driver, "Title").writeContact(contact.getTitle());
        new Input(driver, "Phone").writeContact(contact.getPhone());
        new Input(driver, "MobilePhone").writeContact(contact.getMobile());
        new Input(driver, "Email").writeContact(contact.getEmail());

        new Input(driver, "street").writeMailingStreet(contact.getMailingStreet());
        new Input(driver, "city").writeMailingAddress(contact.getMailingCity());
        new Input(driver, "postalCode").writeMailingAddress(contact.getMailingPostalCode());
        new Input(driver, "province").writeMailingAddress(contact.getMailingState());
        new Input(driver, "country").writeMailingAddress(contact.getMailingCountry());

        new Input(driver, "street").writeOtherStreet(contact.getOtherStreet());
        new Input(driver, "city").writeOtherAddress(contact.getOtherCity());
        new Input(driver, "postalCode").writeOtherAddress(contact.getOtherPostalCode());
        new Input(driver, "province").writeOtherAddress(contact.getOtherState());
        new Input(driver, "country").writeOtherAddress(contact.getOtherCountry());

        new Input(driver, "Fax").writeContact(contact.getFax());
        new Input(driver, "HomePhone").writeContact(contact.getHomePhone());
        new Input(driver, "OtherPhone").writeContact(contact.getOtherPhone());
        new Input(driver, "AssistantPhone").writeContact(contact.getAsstPhone());
        new Input(driver, "AssistantName").writeContact(contact.getAssistant());
        new Input(driver, "Department").writeContact(contact.getDepartment());
        new Input(driver, "Description").writeContactDescription(contact.getDescription());

        return clickSave();
    }

    public ContactDetailsPage clickSave() {
        log.info(">>>>>>>Click on the save new contact button");
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
    }

}
