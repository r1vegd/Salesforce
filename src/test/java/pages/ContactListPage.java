package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactListPage extends BasePage {
    public static final By BREADCRUMBS_CONTACTS = By.xpath("//span[@class='slds-var-p-right_x-small']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(BREADCRUMBS_CONTACTS);
    }

    public ContactListPage open() {
        log.info(">>>>>>>Contact list page has opened");
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    public ContactModalPage clickNew() {
        log.info(">>>>>>>Click on 'New Contact' button");
        driver.findElement(NEW_BUTTON).click();
        return new ContactModalPage(driver);
    }


}
