package com.gunmProg.LibManagement.controllers;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.CopyDto;
import com.gunmProg.LibManagement.models.entities.Copy;
import com.gunmProg.LibManagement.services.contract.CopyService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("copy")
public class CopyController {

    @Autowired
    CopyService copyService;


    @PostMapping(value = "/create")
    ResponseEntity<?> create(@RequestBody CopyDto copyDto) {
        try {
            CopyDto newCopy = copyService.create(copyDto);
            return new ResponseEntity<>(newCopy, HttpStatus.CREATED);
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
    ResponseEntity<?> getByid(@PathVariable Long id) {
        try {
            CopyDto copyDto = copyService.getById(id);
            return new ResponseEntity<>(copyDto, HttpStatus.OK);
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
    ResponseEntity<?> update(@RequestBody CopyDto copywithNewDataDto) {
        try {
            copyService.getById(copywithNewDataDto.getId());
            CopyDto updatedCopyDto = copyService.update(copywithNewDataDto);
            return new ResponseEntity<>(updatedCopyDto, HttpStatus.OK);
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
            CopyDto copyDto = copyService.getById(id);
            copyService.delete(copyDto);
            return new ResponseEntity<>(copyDto, HttpStatus.OK);
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
}
