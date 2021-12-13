package tests;

import models.Account;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login("rivegd-e3pv@force.com", "dev123123123");
        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isAccountModalOpen, "Pop-up не открылся");

        Account account = new Account("TestAccountName", "www.onliner.by",
                "Investor", "TestSalesforceAQA",
                "TestAccountName", "+37533373801", "Apparel",
                "10", "TestBillingStreet",
                "TestBillingCity", "210017",
                "TestBillingState", "Belarus",
                "TestShippingStreet", "TestShippingCity",
                "210017", "TestShippingCity",
                "Minsk");


        boolean isDetailsPageOpen = accountModalPage
                .create(account)
                .isPageOpen();
        accountDetailsPage.detailsTabOpen();
        assertTrue(isDetailsPageOpen, "Страница Details не открылась");

        assertEquals(accountDetailsPage.getFiledValueByName("Account Name"), account.getAccountName(), "Имя аккаунта не совпадает");
        assertEquals(accountDetailsPage.getFiledValueByName("Type"), account.getType(), "Тип аккаунта не совпадает");
        assertEquals(accountDetailsPage.getDetailsWebsite(), account.getWebsite(), "Название веб-сайта аккаунта не совпадает");
        assertEquals(accountDetailsPage.getFiledValueByName("Description"), account.getDescription(), "Описание аккаунта не совпадает");
        assertEquals(accountDetailsPage.getDetailsParentAccount(), account.getParentAccount(), "Название родительского аккаунта не совпадает");
        assertEquals(accountDetailsPage.getDetailsPhone(), account.getPhone(), "Телефон аккаунта не совпадают");
        assertEquals(accountDetailsPage.getFiledValueByName("Industry"), account.getIndustry(), "Индустрия аккаунта");
        assertEquals(accountDetailsPage.getDetailsEmployees(), account.getEmployees(), "Количество работников не совпадает");

        assertEquals(accountDetailsPage.getFieldAddressValue("Billing Address"),
                String.format(account.getBillingStreet() + '\n' + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingPostalCode() + '\n' + account.getBillingCountry()),
                "Адрес оплаты не совпадает");
        assertEquals(accountDetailsPage.getFieldAddressValue("Shipping Address"),
                String.format(account.getShippingStreet() + '\n' + account.getShippingCity() + ", " + account.getShippingState() + " " + account.getShippingPostalCode() + '\n' + account.getShippingCountry()),
                "Адрес доставки не совпадает");

    }


}
