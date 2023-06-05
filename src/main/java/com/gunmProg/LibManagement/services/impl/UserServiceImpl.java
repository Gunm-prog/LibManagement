package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.mappers.UserMapper;
import com.gunmProg.LibManagement.models.dtos.UserDto;
import com.gunmProg.LibManagement.models.entities.User;
import com.gunmProg.LibManagement.repositories.UserRepository;
import com.gunmProg.LibManagement.services.contract.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public static final String ENTITY_NAME="User";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        User newUser = userMapper.convertToUser(userDto);
        userRepository.save(newUser);
        return userMapper.convertToUserDto(newUser);
    }

    @Override
    public UserDto getById(Long id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return userMapper.convertToUserDto(optionalUser.get());
    }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete(userMapper.convertToUser(userDto));
    }
}
