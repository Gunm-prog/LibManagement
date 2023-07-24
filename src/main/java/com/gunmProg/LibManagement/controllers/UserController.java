package com.gunmProg.LibManagement.controllers;

import com.gunmProg.LibManagement.exceptions.AlreadyExistsException;
import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.LoanDto;
import com.gunmProg.LibManagement.models.dtos.UserDto;
import com.gunmProg.LibManagement.services.contract.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping(value = "/findAll")
    ResponseEntity<?> findAll() {
        try {
            List<UserDto> userDtos = userService.findAll();
            return new ResponseEntity<>(userDtos, HttpStatus.OK);
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
    ResponseEntity<?> create(@RequestBody UserDto userDto) {
        try {
            System.out.println(userDto);
            UserDto newUser = userService.create(userDto);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            UserDto userDto = userService.getById(id);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
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

    @PutMapping("/update")
    ResponseEntity<?> update(UserDto userWithNewDataDto) {
        try {
            userService.getById(userWithNewDataDto.getId());
            UserDto updatedUser = userService.update(userWithNewDataDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
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
            UserDto userDto = userService.getById(id);
            userService.delete(userDto);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
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
