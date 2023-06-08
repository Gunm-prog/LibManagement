package com.gunmProg.LibManagement.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String isbn;

    private String title;

    private AuthorDto authorDto;
}
