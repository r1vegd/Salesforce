package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input {
    String inputLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String descriptionLocator = "//textarea[@class=' textarea']";
    String billingStreetLocator = "//textarea[@placeholder='Billing Street']";
    String shippingStreetLocator = "//textarea[@placeholder='Shipping Street']";

    String inputContactLocator = "//input[@name='%s']";
    String addressContactLocator = "//textarea[@name='%s']";


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

    public void writeAddress(String text) {
        driver.findElement(By.xpath(String.format(addressContactLocator, this.label))).sendKeys(text);
    }

}
