package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.LibraryDto;

import java.util.List;

public interface LibraryService {

    List<LibraryDto> findAll();

    LibraryDto create(LibraryDto libraryDto);

    LibraryDto getById(Long id) throws NotFoundException;

    LibraryDto update(LibraryDto libraryWithNewData);

    void delete(LibraryDto libraryDto);
}
