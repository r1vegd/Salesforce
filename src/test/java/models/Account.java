package models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    String accountName;
    String parentAccount;
    String phone;
    String fax;
    String website;
    String type;
    String industry;
    String employees;
    String annualRevenue;
    String description;

    String billingStreet;
    String billingCity;
    String billingPostalCode;
    String billingState;
    String billingCountry;

    String shippingStreet;
    String shippingCity;
    String shippingPostalCode;
    String shippingState;
    String shippingCountry;

}
