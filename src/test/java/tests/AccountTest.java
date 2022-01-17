package tests;

import lombok.extern.log4j.Log4j2;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class AccountTest extends BaseTest {

    @Test(description = "этот тест проверяет позитивный сценарий создания аккаунта")
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login("rivegd1-30cu@force.com", "dev123123123");
        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isAccountModalOpen, "Pop-up не открылся");

        Account account = AccountFactory.getAccount();

        boolean isDetailsPageOpen = accountModalPage
                .create(account)
                .isPageOpen();
        accountDetailsPage.detailsTabOpen();
        assertTrue(isDetailsPageOpen, "Страница Details не открылась");

        assertEquals(accountDetailsPage.getFiledValueByName("Account Name"), account.getAccountName(), "Имя аккаунта не совпадает");
        assertEquals(accountDetailsPage.getDetailsParentAccount(), account.getParentAccount(), "Название родительского аккаунта не совпадает");
        assertEquals(accountDetailsPage.getDetailsPhone(), account.getPhone(), "Телефон аккаунта не совпадают");
        assertEquals(accountDetailsPage.getDetailsFax(), account.getFax(), "Факсы не совпадают");
        assertEquals(accountDetailsPage.getDetailsWebsite(), account.getWebsite(), "Название веб-сайта аккаунта не совпадает");
        assertEquals(accountDetailsPage.getFiledValueByName("Type"), account.getType(), "Тип аккаунта не совпадает");
        assertEquals(accountDetailsPage.getFiledValueByName("Industry"), account.getIndustry(), "Индустрия аккаунта не совпадает");
        assertEquals(accountDetailsPage.getFiledValueByName("Description"), account.getDescription(), "Описание аккаунта не совпадает");
        assertEquals(accountDetailsPage.getDetailsEmployees(), account.getEmployees(), "Количество работников не совпадает");
        assertEquals(accountDetailsPage.getDetailsAnnualRevenue(), String.format("$" + account.getAnnualRevenue()), "Годовой доход не совпадает");
        assertEquals(accountDetailsPage.getFieldAddressValue("Billing Address"),
                String.format(account.getBillingStreet() + '\n' + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingPostalCode() + '\n' + account.getBillingCountry()),
                "Адрес оплаты не совпадает");
        assertEquals(accountDetailsPage.getFieldAddressValue("Shipping Address"),
                String.format(account.getShippingStreet() + '\n' + account.getShippingCity() + ", " + account.getShippingState() + " " + account.getShippingPostalCode() + '\n' + account.getShippingCountry()),
                "Адрес доставки не совпадает");

    }


}
