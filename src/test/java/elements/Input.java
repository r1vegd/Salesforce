package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Input {
    String inputAccountPageLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String inputContactPageLocator = "//input[@name='%s']";

    String descriptionAccountPageLocator = "//textarea[@class=' textarea']";
    String descriptionContactPageLocator = "//textarea[@lightning-textarea_textarea and @maxlength='32000']";

    String addressStreetAccountPageLocator = "//textarea[@placeholder='%s']";
    String mailingStreetContactPageLocator = "(//textarea[@name='street'])[1]";
    String otherStreetContactPageLocator = "(//textarea[@name='%s'])[2]";
    String mailingAddressContactPageLocator = "(//input[@name='%s'])[1]";
    String otherAddressContactPageLocator = "(//input[@name='%s'])[2]";


    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info(String.format(">>>>>>>Write %s into input with label %s",text, label));
        driver.findElement(By.xpath(String.format(inputAccountPageLocator, this.label))).sendKeys(text);
    }

    public void writeDescription(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(descriptionAccountPageLocator))).sendKeys(text);
    }

    public void writeBillingStreet(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(addressStreetAccountPageLocator))).sendKeys(text);
    }

    public void writeShippingStreet(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(addressStreetAccountPageLocator))).sendKeys(text);
    }

    public void writeContact(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.findElement(By.xpath(String.format(inputContactPageLocator, this.label))).sendKeys(text);
    }

    public void writeMailingStreet(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(mailingStreetContactPageLocator, this.label))).sendKeys(text);
    }

    public void writeMailingAddress(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(mailingAddressContactPageLocator, this.label))).sendKeys(text);
    }

    public void writeOtherStreet(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(otherStreetContactPageLocator, this.label))).sendKeys(text);
    }

    public void writeOtherAddress(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(otherAddressContactPageLocator, this.label))).sendKeys(text);
    }

    public void writeContactDescription(String text) {
        log.info(String.format(">>>>>>>Write %s into input", text));
        driver.findElement(By.xpath(String.format(descriptionContactPageLocator, this.label))).sendKeys(text);
    }


}
