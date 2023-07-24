package com.gunmProg.LibManagement.models.dtos;

import com.gunmProg.LibManagement.models.entities.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class AuthorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Set<BookDto> bookDtos;
}
