package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contact {
    String salutation;
    String firstName;
    String lastName;
    String accountName;
    String title;
    String phone;
    String mobile;
    String email;

    String mailingStreet;
    String mailingCity;
    String mailingPostalCode;
    String mailingState;
    String mailingCountry;

    String otherStreet;
    String otherCity;
    String otherPostalCode;
    String otherState;
    String otherCountry;

    String fax;
    String homePhone;
    String otherPhone;
    String asstPhone;
    String assistant;
    String department;
    String description;


}
