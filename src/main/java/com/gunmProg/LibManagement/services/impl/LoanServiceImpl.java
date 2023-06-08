package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.mappers.LoanMapper;
import com.gunmProg.LibManagement.models.dtos.LoanDto;
import com.gunmProg.LibManagement.models.entities.Loan;
import com.gunmProg.LibManagement.repositories.LoanRepository;
import com.gunmProg.LibManagement.services.contract.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

    public static final String ENTITY_NAME= "loan";

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanMapper loanMapper;

    @Override
    public LoanDto create(LoanDto loanDto) {
        Loan newLoan = loanMapper.convertToLoan(loanDto);
        loanRepository.save(newLoan);
        return loanMapper.convertToLoanDto(newLoan);
    }

    @Override
    public LoanDto getById(Long id) throws NotFoundException {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return loanMapper.convertToLoanDto(optionalLoan.get());
    }

    @Override
    public LoanDto update(LoanDto loanWithNewData) {
        Loan updatedLoan = loanRepository.save(
                loanMapper.convertToLoan(loanWithNewData)
        );
        return loanMapper.convertToLoanDto(updatedLoan);
    }

    @Override
    public void delete(LoanDto loanDto) {
        loanRepository.delete(loanMapper.convertToLoan(loanDto));
    }
}
