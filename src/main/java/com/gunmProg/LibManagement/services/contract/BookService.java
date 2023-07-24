package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findAll();

    BookDto create(BookDto bookDto);

    BookDto getById(Long id) throws NotFoundException;

    BookDto update(BookDto bookWithNewData);

    void delete(BookDto bookDto);
}
