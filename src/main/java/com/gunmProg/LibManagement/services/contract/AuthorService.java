package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> findAll();
    AuthorDto create(AuthorDto authorDto);

    AuthorDto getById(Long id) throws NotFoundException;

    AuthorDto update(AuthorDto authorWithNewData);

    void delete(AuthorDto authorDto);


}
