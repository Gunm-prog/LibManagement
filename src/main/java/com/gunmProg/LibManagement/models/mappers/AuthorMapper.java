package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.AuthorDto;
import com.gunmProg.LibManagement.models.entities.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author convertToAuthor(AuthorDto authorDto);

    AuthorDto convertToAuthorDto(Author author);

    List<AuthorDto> convertToAuthorDto(List<Author> authorList);
}
