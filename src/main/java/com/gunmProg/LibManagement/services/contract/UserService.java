package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.UserDto;

public interface UserService {

    UserDto create(UserDto userDto);

    UserDto getById(Long id) throws NotFoundException;

    void delete(UserDto userDto);
}
