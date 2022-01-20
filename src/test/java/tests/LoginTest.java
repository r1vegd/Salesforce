package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test(description = "User inputs login and password and authorizes on platform")
    public void login() {
        boolean isHomePageOpened = loginPage
                .open()
                .login(LOGIN, PASSWORD)
                .isPageOpen();
        assertTrue(isHomePageOpened, "'Home' Page isn't open");
    }
}