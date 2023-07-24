package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.mappers.AuthorMapper;
import com.gunmProg.LibManagement.models.dtos.AuthorDto;
import com.gunmProg.LibManagement.models.entities.Author;
import com.gunmProg.LibManagement.repositories.AuthorRepository;
import com.gunmProg.LibManagement.services.contract.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    public static final String ENTITY_NAME="author";

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public List<AuthorDto> findAll() {
        List<Author> authorList = authorRepository.findAll();
        return authorMapper.convertToAuthorDto(authorList);
    }

    @Override
    public AuthorDto create(AuthorDto authorDto) {
        Author newAuthor = authorMapper.convertToAuthor(authorDto);
        authorRepository.save(newAuthor);
        return authorMapper.convertToAuthorDto(newAuthor);
    }

    @Override
    public AuthorDto getById(Long id) throws NotFoundException {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return authorMapper.convertToAuthorDto(optionalAuthor.get());
    }

    @Override
    public AuthorDto update(AuthorDto authorWithNewData) {
        Author updateAuthor = authorRepository.save(
                authorMapper.convertToAuthor(authorWithNewData)
        );
        return authorMapper.convertToAuthorDto(updateAuthor);
    }

    @Override
    public void delete(AuthorDto authorDto) {
        authorRepository.delete(authorMapper.convertToAuthor(authorDto));
    }

}
