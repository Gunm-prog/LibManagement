package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.UserDto;
import com.gunmProg.LibManagement.models.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AddressMapper.class})
public interface UserMapper {

    User convertToUser(UserDto userDto);

    UserDto convertToUserDto(User user);

    List<UserDto> convertToUserDto(List<User> userList);
}
