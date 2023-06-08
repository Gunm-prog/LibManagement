package com.gunmProg.LibManagement.controllers;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.AuthorDto;
import com.gunmProg.LibManagement.models.dtos.LoanDto;
import com.gunmProg.LibManagement.services.contract.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;

@Slf4j
@RestController
@RequestMapping("loan")
public class LoanController {

    @Autowired
    LoanService loanService;


    @PostMapping(value = "/create")
    ResponseEntity<?> create(@RequestBody LoanDto loanDto) {
        try {
            LoanDto newLoan = loanService.create(loanDto);
            return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
        } catch (NotFoundException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        } catch (Exception exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            LoanDto loanDto = loanService.getById(id);
            return new ResponseEntity<>(loanDto, HttpStatus.OK);
        } catch (NotFoundException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        } catch (Exception exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @PutMapping(value = "/update")
    ResponseEntity<?> upddate(LoanDto loanWithNewDataDto) {
        try {
            loanService.getById(loanWithNewDataDto.getId());
            LoanDto updatedLoan = loanService.update(loanWithNewDataDto);
            return new ResponseEntity<>(loanWithNewDataDto, HttpStatus.OK);
        } catch (NotFoundException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        } catch (Exception exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            LoanDto loanDto = loanService.getById(id);
            loanService.delete(loanDto);
            return new ResponseEntity<>(loanDto, HttpStatus.OK);
        } catch (NotFoundException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }
}
