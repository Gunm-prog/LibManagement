package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.AuthorDto;
import com.gunmProg.LibManagement.models.dtos.BookDto;
import com.gunmProg.LibManagement.models.entities.Author;
import com.gunmProg.LibManagement.models.entities.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {

    Book convertToBook(BookDto bookDto);

    BookDto convertToBookDto(Book book);

    List<BookDto> convertToBookDto(List<Book> bookList);
}
