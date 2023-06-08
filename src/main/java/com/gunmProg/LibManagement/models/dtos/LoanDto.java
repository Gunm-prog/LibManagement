package com.gunmProg.LibManagement.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class LoanDto {

    private Long id;

    private Date startDate;

    private Date endDate;

    private boolean isReturned;

    private CopyDto copyDto;

    private UserDto userDto;
}
