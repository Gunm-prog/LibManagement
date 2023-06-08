package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.UserDto;
import com.gunmProg.LibManagement.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User convertToUser(UserDto userDto);

    UserDto convertToUserDto(User user);
}
