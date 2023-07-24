package com.gunmProg.LibManagement.models.mappers;

import com.gunmProg.LibManagement.models.dtos.LibraryDto;
import com.gunmProg.LibManagement.models.entities.Library;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AddressMapper.class})
public interface LibraryMapper {

    Library convertToLibrary(LibraryDto libraryDto);

    LibraryDto convertToLibraryDto(Library library);


    List<LibraryDto> convertToLibraryDto(List<Library> libraryList);
}
