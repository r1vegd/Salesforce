package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class AccountFactory {
    static Faker faker = new Faker();

    public static Account getAccount() {
        return Account.builder()
                .accountName(faker.funnyName().name())
                .parentAccount("TestAccountName")
                .phone(faker.phoneNumber().cellPhone())
                .fax(faker.phoneNumber().subscriberNumber(7))
                .website(faker.internet().url())
                .type("Investor")
                .industry("Apparel")
                .employees(faker.number().digits(1))
                .annualRevenue(faker.number().digits(1))
                .description(faker.harryPotter().character())

                .billingStreet(faker.address().streetAddress())
                .billingCity(faker.address().cityName())
                .billingPostalCode(faker.address().zipCode())
                .billingState(faker.address().state())
                .billingCountry(faker.address().country())

                .shippingStreet(faker.address().streetAddress())
                .shippingCity(faker.address().cityName())
                .shippingPostalCode(faker.address().zipCode())
                .shippingState(faker.address().state())
                .shippingCountry(faker.address().country())
                .build();

    }
}
