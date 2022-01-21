package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected AccountListPage accountListPage;
    protected AccountModalPage accountModalPage;
    protected AccountDetailsPage accountDetailsPage;
    protected ContactListPage contactListPage;
    protected ContactModalPage contactModalPage;
    protected ContactDetailsPage contactDetailsPage;

    public static final String LOGIN = "rivegd1-30cu@force.com";
    public static final String PASSWORD = "dev123123123";

    @BeforeMethod(description = "Setup and start browser")
    public void setUp() {
        log.info("Browser launch");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountListPage = new AccountListPage(driver);
        accountModalPage = new AccountModalPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        contactListPage = new ContactListPage(driver);
        contactModalPage = new ContactModalPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        log.info("Browser closing");
        driver.quit();
    }


}