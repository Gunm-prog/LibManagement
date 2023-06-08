package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.LibraryDto;
import com.gunmProg.LibManagement.models.entities.Library;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    Library convertToLibrary(LibraryDto libraryDto);

    LibraryDto convertToLibraryDto(Library library);
}
