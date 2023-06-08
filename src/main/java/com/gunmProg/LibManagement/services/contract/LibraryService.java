package com.gunmProg.LibManagement.services.contract;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.dtos.LibraryDto;

public interface LibraryService {

    LibraryDto create(LibraryDto libraryDto);

    LibraryDto getById(Long id) throws NotFoundException;

    LibraryDto update(LibraryDto libraryWithNewData);

    void delete(LibraryDto libraryDto);
}
