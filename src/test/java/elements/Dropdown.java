package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Dropdown {
    String dropdownAccountPageLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]/div[@class='uiMenu']";
    String optionAccountPageLocator = "//div[contains(@class, 'visible')]//a[@title='%s']";
    String parentAccountPageLocator = "//input[@placeholder='Search Accounts...']";
    String parentAccountPageOptionLocator = "(//div[@title='TestAccountName'])[1]";

    String dropdownContactPageLocator = "//input[@placeholder='%s']";
    String optionContactPageLocator = "//span[@title='%s']";

    WebDriver driver;
    String label;

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.info(String.format(">>>>>>>Select %s in dropdown", option));
        driver.findElement(By.xpath(String.format(dropdownAccountPageLocator, this.label))).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(By.xpath(String.format(optionAccountPageLocator, option))).click();

    }

    public void selectParentAccount(String parentAccountOption) {
        log.info(String.format(">>>>>>>Select %s in dropdown", parentAccountOption));
        driver.findElement(By.xpath(String.format(parentAccountPageLocator))).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(By.xpath(String.format(parentAccountPageOptionLocator))).click();
    }

    public void selectContactDropdown(String option) {
        log.info(String.format(">>>>>>>Select %s in dropdown", option));
        driver.findElement(By.xpath(String.format(dropdownContactPageLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionContactPageLocator, option))).click();
    }

}
