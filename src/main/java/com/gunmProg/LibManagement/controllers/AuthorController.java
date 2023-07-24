package com.gunmProg.LibManagement.controllers;

import com.gunmProg.LibManagement.exceptions.AlreadyExistsException;
import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.AuthorDto;
import com.gunmProg.LibManagement.services.contract.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/findAll")
    ResponseEntity<?> findAll(){
        try{
            List<AuthorDto> authorDtos = authorService.findAll();
            return new ResponseEntity<>(authorDtos, HttpStatus.OK);
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


    @PostMapping(value = "/create")
    ResponseEntity<?> create(@RequestBody AuthorDto authorDto) {
        try {
            AuthorDto newAuthor = authorService.create(authorDto);
            return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
        }catch (Exception exception) {
            log.warn( exception.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            AuthorDto authorDto = authorService.getById(id);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }catch ( NotFoundException exception) {
            log.warn( exception.getMessage());
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
    ResponseEntity<?> update(@RequestBody AuthorDto authorWithNewDataDto) {
        try {
            authorService.getById(authorWithNewDataDto.getId());
            AuthorDto updatedAuthorDto = authorService.update(authorWithNewDataDto);
            return new ResponseEntity<>(updatedAuthorDto, HttpStatus.OK);
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
            AuthorDto authorDto = authorService.getById(id);
            authorService.delete(authorDto);
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
                    .body("INTERNAL_SERVER_ERROR");
        }
    }
}
