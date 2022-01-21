package tests;

import lombok.extern.log4j.Log4j2;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AccountTest extends BaseTest {

    @Test(description = "Positive account create test")
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login(LOGIN, PASSWORD);
        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isAccountModalOpen, "Pop-up isn't open");

        Account account = AccountFactory.getAccount();

        boolean isDetailsPageOpen = accountModalPage
                .create(account)
                .isPageOpen();
        accountDetailsPage.detailsTabOpen();
        assertTrue(isDetailsPageOpen, "'Details' page isn't open");

        assertEquals(accountDetailsPage.getFiledValueByName("Account Name"), account.getAccountName(), "Account name doesn't match");
        assertEquals(accountDetailsPage.getDetailsParentAccount(), account.getParentAccount(), "Parent account name doesn't match");
        assertEquals(accountDetailsPage.getDetailsPhone(), account.getPhone(), "Phone doesn't match");
        assertEquals(accountDetailsPage.getDetailsFax(), account.getFax(), "Fax doesn't match");
        assertEquals(accountDetailsPage.getDetailsWebsite(), account.getWebsite(), "Website doesn't match");
        assertEquals(accountDetailsPage.getFiledValueByName("Type"), account.getType(), "Type doesn't match");
        assertEquals(accountDetailsPage.getFiledValueByName("Industry"), account.getIndustry(), "Industry doesn't match");
        assertEquals(accountDetailsPage.getFiledValueByName("Description"), account.getDescription(), "Description doesn't match");
        assertEquals(accountDetailsPage.getDetailsEmployees(), account.getEmployees(), "Employees qty doesn't match");
        assertEquals(accountDetailsPage.getDetailsAnnualRevenue(), String.format("$" + account.getAnnualRevenue()), "Annual Revenue doesn't match");
        assertEquals(accountDetailsPage.getFieldAddressValue("Billing Address"),
                String.format(account.getBillingStreet() + '\n' + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingPostalCode() + '\n' + account.getBillingCountry()),
                "Billing address doesn't match");
        assertEquals(accountDetailsPage.getFieldAddressValue("Shipping Address"),
                String.format(account.getShippingStreet() + '\n' + account.getShippingCity() + ", " + account.getShippingState() + " " + account.getShippingPostalCode() + '\n' + account.getShippingCountry()),
                "Shipping address doesn't match");

    }


}
