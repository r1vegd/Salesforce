package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "этот тест проверяет вход на сайт")
    public void login() {
        boolean isHomePageOpened = loginPage
                .open()
                .login("rivegd1-30cu@force.com", "dev123123123")
                .isPageOpen();

        assertTrue(isHomePageOpened, "Страница HomePage не открылась");
    }
}