package tests;

import models.Contact;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest {


    @Test(description = "этот тест проверяет позитивный сценарий создания контакта")
    public void contactShouldBeCreated() {
        loginPage
                .open()
                .login("rivegd-e3pv@force.com", "dev123123123");
        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop-up не открылся");

        Contact contact = new Contact("Mr.", myRandomString, myRandomString,
                myRandomString, myRandomString,
                "TestAccountName", myRandomString,
                "test@gmail.ru", myRandomString,
                "+375441233232", "Test",
                "12345678", "TestMailingStreet", "TestMailingCity",
                "TestPostalCode", "TestMailingState",
                "TestMailingCountry");

        boolean isDetailsPageOpen = contactModalPage
                .create(contact)
                .isPageOpen();
        contactDetailsPage.detailsTabOpen();
        assertTrue(isDetailsPageOpen, "Страница Details не открылась");

        assertEquals(contactDetailsPage.getDetailsName(),
                String.format(contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName() + " " + contact.getSuffix()),
                "Имя аккаунта не совпадает");
        assertEquals(contactDetailsPage.getDetailsAccountName("Account Name"), contact.getAccountName(), "Account Name не совпадают");
        assertEquals(contactDetailsPage.getDetailsTitleNDepartment("Title"), contact.getTitle(), "Title не совпадают");
        assertEquals(contactDetailsPage.getDetailsEmail(), contact.getEmail(), "Email не совпадают");
        assertEquals(contactDetailsPage.getDetailsContactInformation("Phone"), contact.getPhone(), "Phone не совпадают");
        assertEquals(contactDetailsPage.getDetailsContactInformation("Mobile"), contact.getMobile(), "Mobile не совпадают");
        assertEquals(contactDetailsPage.getDetailsTitleNDepartment("Department"), contact.getDepartment(), "Department не совпадают");
        assertEquals(contactDetailsPage.getDetailsFax(), contact.getFax(), "Fax не совпадают");
        assertEquals(contactDetailsPage.getDetailsContactInformation("Mailing Address"),
                String.format(contact.getMailingStreet() + '\n' + contact.getMailingCity() + ", " + contact.getMailingState() + " " + contact.getMailingPostalCode() + '\n' + contact.getMailingCountry()),
                "Mailing Address");

        assertEquals("", "");

    }

}
