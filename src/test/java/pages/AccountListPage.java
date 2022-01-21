package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountListPage extends BasePage {
    public static final By BREADCRUMBS_LABEL = By.xpath("//nav[@aria-label='Breadcrumbs']//span");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        log.info(">>>>>>>Account list page has open");
        return isExist(BREADCRUMBS_LABEL);
    }

    public AccountListPage open() {
        log.info(">>>>>>>Account List Page is opening");
        driver.get(BASE_URL + "/lightning/o/Account/list");
        return this;
    }

    public AccountModalPage clickNew() {
        log.info(">>>>>>>Click on 'New Account' button");
        driver.findElement(NEW_BUTTON).click();
        return new AccountModalPage(driver);
    }

}
