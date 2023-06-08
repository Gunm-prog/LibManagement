package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.BookDto;
import com.gunmProg.LibManagement.models.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book convertToBook(BookDto bookDto);

    BookDto convertToBookDto(Book book);
}
