package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto create(UserDto userDto);

    UserDto getById(Long id) throws NotFoundException;

    UserDto update(UserDto userWithNewData);

    void delete(UserDto userDto);

    void isActive(UserDto userDto);
}
