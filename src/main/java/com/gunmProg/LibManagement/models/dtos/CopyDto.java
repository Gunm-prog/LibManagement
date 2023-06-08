package com.gunmProg.LibManagement.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CopyDto {

    private Long id;

    private boolean isAvailable;

    private BookDto bookDto;

    private LibraryDto libraryDto;
}
