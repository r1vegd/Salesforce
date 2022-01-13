package tests;

import lombok.extern.log4j.Log4j2;
import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class ContactTest extends BaseTest {

    @Test(description = "этот тест проверяет позитивный сценарий создания контакта")
    public void contactShouldBeCreated() {
        log.info("Старт теста contactShouldBeCreated");
        loginPage
                .open()
                .login("rivegd1-30cu@force.com", "dev123123123");
        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop-up не открылся");

        Contact contact = ContactFactory.getContact();

        boolean isDetailsPageOpen = contactModalPage
                .create(contact)
                .isPageOpen();
        contactDetailsPage.detailsTabOpen();
        assertTrue(isDetailsPageOpen, "Страница Details не открылась");

        assertEquals(contactDetailsPage.getDetailsName(),
                String.format(contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName(), "Имя аккаунта не совпадает"));
        assertEquals(contactDetailsPage.getDetailsAccountName("Account Name"), contact.getAccountName(), "Account Name не совпадают");
        assertEquals(contactDetailsPage.getDetailsDepartment("Title"), contact.getTitle(), "Title не совпадают");
        assertEquals(contactDetailsPage.getDetailsPhone(), contact.getPhone(), "Phone не совпадают");
        assertEquals(contactDetailsPage.getDetailsMobile(), contact.getMobile(), "Mobile не совпадают");
        assertEquals(contactDetailsPage.getDetailsEmail(), contact.getEmail(), "Email не совпадают");
        assertEquals(contactDetailsPage.getDetailsContactInformation("Mailing Address"),
                String.format(contact.getMailingStreet() + '\n' + contact.getMailingCity() + ", " + contact.getMailingState() + " " + contact.getMailingPostalCode() + '\n' + contact.getMailingCountry()),
                "Mailing Address не совпадает");
        assertEquals(contactDetailsPage.getDetailsOtherInformation("Mailing Address"),
                String.format(contact.getOtherStreet() + '\n' + contact.getOtherCity() + ", " + contact.getOtherState() + " " + contact.getOtherPostalCode() + '\n' + contact.getOtherCountry()),
                "Other Address не совпадает");
        assertEquals(contactDetailsPage.getDetailsFax(), contact.getFax(), "Fax не совпадают");
        assertEquals(contactDetailsPage.getDetailsHomePhone("Home Phone"), contact.getHomePhone(), "Home Phone не совпадают");
        assertEquals(contactDetailsPage.getDetailsOtherPhone("Other Phone"), contact.getOtherPhone(), "Other Phone не совпадают");
        assertEquals(contactDetailsPage.getDetailsAsstPhone("Asst. Phone"), contact.getAsstPhone(), "Asst. Phone не совпадают");
        assertEquals(contactDetailsPage.getDetailsAssistant("Assistant"), contact.getAssistant(), "Assistant не совпадают");
        assertEquals(contactDetailsPage.getDetailsDesc("Description"), contact.getDescription(), "Description не совпадают");
        assertEquals(contactDetailsPage.getDetailsDepartment("Department"), contact.getDepartment(), "Department не совпадают");
        log.info("Завершение теста contactShouldBeCreated");
    }

}
