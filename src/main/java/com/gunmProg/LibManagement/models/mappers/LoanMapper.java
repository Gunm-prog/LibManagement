package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.LoanDto;
import com.gunmProg.LibManagement.models.entities.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan convertToLoan(LoanDto loanDto);

    LoanDto convertToLoanDto(Loan loan);
}
