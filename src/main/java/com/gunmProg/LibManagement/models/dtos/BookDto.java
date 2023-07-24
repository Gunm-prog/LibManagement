package com.gunmProg.LibManagement.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String isbn;

    private String title;

    /**
     * pas private AuthorDto authorDto le nom doit être le même que dans l'objet book sinon
     * le mapper ne trouve pas les bonnes informations et donnera un author=null
     * Attention au typage différent du nom de variable: ici le nom de la variable c'est author!!!!
     * comme dans l'objet book!!!
    */
    private AuthorDto author;
}
