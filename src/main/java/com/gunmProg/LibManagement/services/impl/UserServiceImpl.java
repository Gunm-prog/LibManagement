package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.AlreadyExistsException;
import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.mappers.UserMapper;
import com.gunmProg.LibManagement.models.dtos.UserDto;
import com.gunmProg.LibManagement.models.entities.User;
import com.gunmProg.LibManagement.repositories.UserRepository;
import com.gunmProg.LibManagement.services.contract.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        return userMapper.convertToUserDto(userList);
    }
    @Override
    public UserDto create(UserDto userDto) throws AlreadyExistsException {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new AlreadyExistsException(ENTITY_NAME + " email already exists");
        }else {
            User newUser = userMapper.convertToUser(userDto);
            System.out.println(newUser);
            userRepository.save(newUser);
            return userMapper.convertToUserDto(newUser);
        }
    }

    @Override
    public UserDto getById(Long id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return userMapper.convertToUserDto(optionalUser.get());
    }

    @Override
    public UserDto update(UserDto userWithNewData) {
        User updatedUser = userRepository.save(
                userMapper.convertToUser(userWithNewData)
        );
        return userMapper.convertToUserDto(updatedUser);
    }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete(
                userMapper.convertToUser(userDto)
        );
    }

    @Override
    public void isActive(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new NotFoundException(ENTITY_NAME + " email already exists");
        }
        if (userDto.getAddress() == null) {
            throw new NotFoundException(ENTITY_NAME + " address not found");
        }
        userMapper.convertToUserDto(optionalUser.get());

    }
}
