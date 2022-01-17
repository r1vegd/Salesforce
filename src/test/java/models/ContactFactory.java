package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class ContactFactory {
    static Faker faker = new Faker();

    public static Contact getContact() {
        return Contact.builder()
                .salutation("Mr.")
                .firstName(faker.witcher().witcher())
                .lastName(faker.witcher().character())
                .accountName("TestAccountName")
                .title(faker.esports().player())
                .phone(faker.phoneNumber().phoneNumber())
                .mobile(faker.phoneNumber().cellPhone())
                .email(faker.internet().emailAddress())

                .mailingStreet(faker.address().streetAddress())
                .mailingCity(faker.address().cityName())
                .mailingPostalCode(faker.number().digits(1))
                .mailingState(faker.address().state())
                .mailingCountry(faker.address().country())

                .otherStreet(faker.address().streetAddress())
                .otherCity(faker.address().cityName())
                .otherPostalCode(faker.number().digits(1))
                .otherState(faker.address().state())
                .otherCountry(faker.address().country())

                .fax(faker.phoneNumber().subscriberNumber())
                .homePhone(faker.phoneNumber().phoneNumber())
                .otherPhone(faker.phoneNumber().phoneNumber())
                .asstPhone(faker.phoneNumber().cellPhone())
                .assistant(faker.esports().player())
                .department(faker.company().logo())
                .description(faker.programmingLanguage().name())

                .build();
    }
}
