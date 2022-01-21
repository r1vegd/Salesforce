package tests;

import lombok.extern.log4j.Log4j2;
import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ContactTest extends BaseTest {

    @Test(description = "Positive contact create test")
    public void contactShouldBeCreated() {
        loginPage
                .open()
                .login(LOGIN, PASSWORD);
        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop-up isn't open");

        Contact contact = ContactFactory.getContact();

        boolean isDetailsPageOpen = contactModalPage
                .create(contact)
                .isPageOpen();
        contactDetailsPage.detailsTabOpen();
        assertTrue(isDetailsPageOpen, "'Details' page isn't open");

        assertEquals(contactDetailsPage.getDetailsName(),
                String.format(contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName(), "Account name doesn't match"));
        assertEquals(contactDetailsPage.getDetailsAccountName("Account Name"), contact.getAccountName(), "Account name doesn't match");
        assertEquals(contactDetailsPage.getDetailsDepartment("Title"), contact.getTitle(), "Title doesn't match");
        assertEquals(contactDetailsPage.getDetailsPhone(), contact.getPhone(), "Phone doesn't match");
        assertEquals(contactDetailsPage.getDetailsMobile(), contact.getMobile(), "Mobile doesn't match");
        assertEquals(contactDetailsPage.getDetailsEmail(), contact.getEmail(), "Email doesn't match");
        assertEquals(contactDetailsPage.getDetailsContactInformation("Mailing Address"),
                String.format(contact.getMailingStreet() + '\n' + contact.getMailingCity() + ", " + contact.getMailingState() + " " + contact.getMailingPostalCode() + '\n' + contact.getMailingCountry()),
                "Mailing Address doesn't match");
        assertEquals(contactDetailsPage.getDetailsOtherInformation("Mailing Address"),
                String.format(contact.getOtherStreet() + '\n' + contact.getOtherCity() + ", " + contact.getOtherState() + " " + contact.getOtherPostalCode() + '\n' + contact.getOtherCountry()),
                "Other Address doesn't match");
        assertEquals(contactDetailsPage.getDetailsFax(), contact.getFax(), "Fax doesn't match");
        assertEquals(contactDetailsPage.getDetailsHomePhone("Home Phone"), contact.getHomePhone(), "Home Phone doesn't match");
        assertEquals(contactDetailsPage.getDetailsOtherPhone("Other Phone"), contact.getOtherPhone(), "Other Phone doesn't match");
        assertEquals(contactDetailsPage.getDetailsAsstPhone("Asst. Phone"), contact.getAsstPhone(), "Asst. Phone doesn't match");
        assertEquals(contactDetailsPage.getDetailsAssistant("Assistant"), contact.getAssistant(), "Assistant doesn't match");
        assertEquals(contactDetailsPage.getDetailsDesc("Description"), contact.getDescription(), "Description doesn't match");
        assertEquals(contactDetailsPage.getDetailsDepartment("Department"), contact.getDepartment(), "Department doesn't match");
    }

}
