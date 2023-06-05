package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.LoanDto;

public interface LoanService {

    LoanDto create(LoanDto loanDto);

    LoanDto getById(Long id) throws NotFoundException;

    void delete(LoanDto loanDto);
}
