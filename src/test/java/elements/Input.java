package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    String inputLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String descriptionLocator = "//textarea[@class=' textarea']";
    String billingStreetLocator = "//textarea[@placeholder='Billing Street']";
    String shippingStreetLocator = "//textarea[@placeholder='Shipping Street']";

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


}
