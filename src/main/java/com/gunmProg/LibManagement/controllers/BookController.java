package com.gunmProg.LibManagement.controllers;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.BookDto;
import com.gunmProg.LibManagement.services.contract.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping(value = "/create")
    ResponseEntity<?> create(@RequestBody BookDto bookDto) {
        try {
            BookDto newBook = bookService.create(bookDto);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
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
            BookDto bookDto = bookService.getById(id);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        } catch (NotFoundException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        } catch (Exception exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVOR_ERROR");
        }
    }

    @PutMapping(value = "/update")
    ResponseEntity<?> update(@RequestBody BookDto bookWithNewDataDto) {
        try {
            bookService.getById(bookWithNewDataDto.getId());
            BookDto updatedBookDto = bookService.update(bookWithNewDataDto);
            return new ResponseEntity<>(updatedBookDto, HttpStatus.OK);
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
            BookDto bookDto = bookService.getById(id);
            bookService.delete(bookDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        } catch (Exception exception) {
            log.warn(exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVOR_ERROR");
        }
    }
}
