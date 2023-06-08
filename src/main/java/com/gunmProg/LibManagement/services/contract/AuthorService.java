package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.AuthorDto;

public interface AuthorService {

    AuthorDto create(AuthorDto authorDto);

    AuthorDto getById(Long id) throws NotFoundException;

    AuthorDto update(AuthorDto authorWithNewData);

    void delete(AuthorDto authorDto);
}
