package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.AlreadyExistsException;
import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.mappers.LibraryMapper;
import com.gunmProg.LibManagement.models.dtos.LibraryDto;
import com.gunmProg.LibManagement.models.entities.Library;
import com.gunmProg.LibManagement.repositories.LibraryRepository;
import com.gunmProg.LibManagement.services.contract.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LibraryServiceImpl implements LibraryService {

    public static final String ENTITY_NAME= "library";

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    LibraryMapper libraryMapper;


    @Override
    public List<LibraryDto> findAll() {
        List<Library> libraryList = libraryRepository.findAll();
        return libraryMapper.convertToLibraryDto(libraryList);
    }
    @Override
    public LibraryDto create(LibraryDto libraryDto) throws AlreadyExistsException {
        Optional<Library> optionalLibrary = libraryRepository.findByName(libraryDto.getName());
        if (optionalLibrary.isPresent()) {
            throw new AlreadyExistsException(ENTITY_NAME + " library already exists");
        } else {
            System.out.println(libraryDto);
            Library newLibrary = libraryMapper.convertToLibrary(libraryDto);
            libraryRepository.save(newLibrary);
            return libraryMapper.convertToLibraryDto(newLibrary);
        }
    }

    @Override
    public LibraryDto getById(Long id) throws NotFoundException {
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if (optionalLibrary.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return libraryMapper.convertToLibraryDto(optionalLibrary.get());
    }

    @Override
    public LibraryDto update(LibraryDto libraryWithNewData) {
        Library updatedLibrary = libraryRepository.save(
                libraryMapper.convertToLibrary(libraryWithNewData)
        );
        return libraryMapper.convertToLibraryDto(updatedLibrary);
    }

    @Override
    public void delete(LibraryDto libraryDto) {
        libraryRepository.delete(libraryMapper.convertToLibrary(libraryDto));

    }
}
