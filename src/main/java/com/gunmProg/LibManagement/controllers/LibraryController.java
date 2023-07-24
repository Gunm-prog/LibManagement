package com.gunmProg.LibManagement.controllers;

import ch.qos.logback.core.model.INamedModel;
import com.gunmProg.LibManagement.exceptions.AlreadyExistsException;
import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.LibraryDto;
import com.gunmProg.LibManagement.services.contract.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;


    @GetMapping(value = "/findAll")
    ResponseEntity<?> findAll() {
        try {
           List<LibraryDto> libraryDtos =  libraryService.findAll();
            return new ResponseEntity<>(libraryDtos, HttpStatus.OK);
        }catch (NotFoundException | AlreadyExistsException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }catch (Exception exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @PostMapping(value = "/create")
    ResponseEntity<?> create(@RequestBody LibraryDto libraryDto) {
        try {
            log.debug(libraryDto.toString());
            System.out.println(libraryDto);


            LibraryDto newLibrary = libraryService.create(libraryDto);
            System.out.println(newLibrary);
            return new ResponseEntity<>(newLibrary, HttpStatus.CREATED);
        } catch (NotFoundException | AlreadyExistsException exception) {
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
            LibraryDto libraryDto = libraryService.getById(id);
            return new ResponseEntity<>(libraryDto, HttpStatus.OK);
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
    ResponseEntity<?> update(@RequestBody LibraryDto libraryWithNewDataDto) {
        try {
            System.out.println(libraryWithNewDataDto);
            libraryService.getById(libraryWithNewDataDto.getId());
            LibraryDto updatedLibrary = libraryService.update(libraryWithNewDataDto);
            return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
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
            LibraryDto libraryDto = libraryService.getById(id);
            libraryService.delete(libraryDto);
            return new ResponseEntity<>(libraryDto, HttpStatus.OK);
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
