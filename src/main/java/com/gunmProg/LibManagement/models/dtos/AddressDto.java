package com.gunmProg.LibManagement.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddressDto {

    private int number;

    private String street;

    private String zipCode;

    private String city;
}
