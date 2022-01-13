package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Input {
    String inputLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String descriptionLocator = "//textarea[@class=' textarea']";
    String billingStreetLocator = "//textarea[@placeholder='Billing Street']";
    String shippingStreetLocator = "//textarea[@placeholder='Shipping Street']";

    String inputContactLocator = "//input[@name='%s']";
    String mailingStreetContactLocator = "(//textarea[@name='street'])[1]";
    String otherStreetContactLocator = "(//textarea[@name='%s'])[2]";
    String mailingAddressContactLocator = "(//input[@name='%s'])[1]";
    String otherAddressContactLocator = "(//input[@name='%s'])[2]";
    String descriptionContactLocator = "//textarea[@lightning-textarea_textarea and @maxlength='32000']";

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into input with label '%s' ", text, this.label);
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
    }

    public void writeDescription(String text) {
        driver.findElement(By.xpath(String.format(descriptionLocator))).sendKeys(text);
    }

    public void writeBillingStreet(String text) {
        driver.findElement(By.xpath(String.format(billingStreetLocator))).sendKeys(text);
    }

    public void writeShippingStreet(String text) {
        driver.findElement(By.xpath(String.format(shippingStreetLocator))).sendKeys(text);
    }

    public void writeContact(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.findElement(By.xpath(String.format(inputContactLocator, this.label))).sendKeys(text);
    }

    public void writeMailingStreet(String text) {
        driver.findElement(By.xpath(String.format(mailingStreetContactLocator, this.label))).sendKeys(text);
    }

    public void writeMailingAddress(String text) {
        driver.findElement(By.xpath(String.format(mailingAddressContactLocator, this.label))).sendKeys(text);
    }

    public void writeOtherStreet(String text) {
        driver.findElement(By.xpath(String.format(otherStreetContactLocator, this.label))).sendKeys(text);
    }

    public void writeOtherAddress(String text) {
        driver.findElement(By.xpath(String.format(otherAddressContactLocator, this.label))).sendKeys(text);
    }

    public void writeContactDescription(String text) {
        driver.findElement(By.xpath(String.format(descriptionContactLocator, this.label))).sendKeys(text);
    }


}
