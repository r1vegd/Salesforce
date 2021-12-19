package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "этот тест проверяет вход на сайт")
    public void login() {
        boolean isHomePageOpened = loginPage
                .open()
                .login("rivegd-e3pv@force.com", "dev123123123")
                .isPageOpen();

        assertTrue(isHomePageOpened, "Страница HomePage не открылась");
    }
}