package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Dropdown {
    String dropdownLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]/div[@class='uiMenu']";
    String optionLocator = "//div[contains(@class, 'visible')]//a[@title='%s']";
    String parentAccountLocator = "//input[@placeholder='Search Accounts...']";
    String parentAccountOptionLocator = "(//div[@title='TestAccountName'])[1]";

    String dropdownContactLocator = "//input[@placeholder='%s']";
    String optionContactLocator = "//span[@title='%s']";


    WebDriver driver;
    String label;

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.info(String.format(">>>>>>>Select %s in dropdown", option));
        driver.findElement(By.xpath(String.format(dropdownLocator, this.label))).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();

    }

    public void selectParentAccount(String parentAccountOption) {
        log.info(String.format(">>>>>>>Select %s in dropdown", parentAccountOption));
        driver.findElement(By.xpath(String.format(parentAccountLocator))).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(By.xpath(String.format(parentAccountOptionLocator))).click();
    }

    public void selectContactDropdown(String option) {
        log.info(String.format(">>>>>>>Select %s in dropdown", option));
        driver.findElement(By.xpath(String.format(dropdownContactLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionContactLocator, option))).click();
    }

}
