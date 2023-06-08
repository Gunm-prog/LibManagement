package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.BookDto;

public interface BookService {

    BookDto create(BookDto bookDto);

    BookDto getById(Long id) throws NotFoundException;

    BookDto update(BookDto bookWithNewData);

    void delete(BookDto bookDto);
}
