package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.mappers.BookMapper;
import com.gunmProg.LibManagement.models.dtos.BookDto;
import com.gunmProg.LibManagement.models.entities.Book;
import com.gunmProg.LibManagement.repositories.BookRepository;
import com.gunmProg.LibManagement.services.contract.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    public static final String ENTITY_NAME= "book";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDto create(BookDto bookDto) {
        Book newBook = bookMapper.convertToBook(bookDto);
        bookRepository.save(newBook);
        return bookMapper.convertToBookDto(newBook);
    }

    @Override
    public BookDto getById(Long id) throws NotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) throw new NotFoundException(ENTITY_NAME + " not found");
        return bookMapper.convertToBookDto(optionalBook.get());
    }

    @Override
    public BookDto update(BookDto bookWithNewData) {
        Book updatedBook = bookRepository.save(
                bookMapper.convertToBook(bookWithNewData)
        );
        return bookMapper.convertToBookDto(updatedBook);
    }

    @Override
    public void delete(BookDto bookDto) {
        bookRepository.delete(bookMapper.convertToBook(bookDto));
    }
}
