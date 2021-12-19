package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        System.out.printf("Select option '%s' into dropdown with label '%s'", option, this.label);
        driver.findElement(By.xpath(String.format(dropdownLocator, this.label))).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();

    }

    public void selectParentAccount(String parentAccountOption) {
        driver.findElement(By.xpath(String.format(parentAccountLocator))).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.findElement(By.xpath(String.format(parentAccountOptionLocator))).click();
    }

    public void selectContactDropdown(String option) {
        driver.findElement(By.xpath(String.format(dropdownContactLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionContactLocator, option))).click();
    }

}
