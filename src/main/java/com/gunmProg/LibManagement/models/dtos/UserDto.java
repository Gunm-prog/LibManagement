package com.gunmProg.LibManagement.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Long Id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean isActive;

    private String roles;

    private Set<LoanDto> loanDtos;

    private CopyDto copyDto;

    private AddressDto address;


}
