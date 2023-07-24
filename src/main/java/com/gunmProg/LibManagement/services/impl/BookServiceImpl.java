package com.gunmProg.LibManagement.services.impl;

import com.gunmProg.LibManagement.exceptions.NotFoundException;
import com.gunmProg.LibManagement.models.entities.Author;
import com.gunmProg.LibManagement.models.mappers.AuthorMapper;
import com.gunmProg.LibManagement.models.mappers.BookMapper;
import com.gunmProg.LibManagement.models.dtos.BookDto;
import com.gunmProg.LibManagement.models.entities.Book;
import com.gunmProg.LibManagement.repositories.AuthorRepository;
import com.gunmProg.LibManagement.repositories.BookRepository;
import com.gunmProg.LibManagement.services.contract.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    public static final String ENTITY_NAME= "book";

    @Autowired
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Autowired
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;

    @Autowired
    public BookServiceImpl (BookRepository bookRepository,
                            BookMapper bookMapper,
                            AuthorRepository authorRepository,
                            AuthorMapper authorMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }


    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = bookRepository.findAll();
        return bookMapper.convertToBookDto(bookList);
    }

    @Override
    public BookDto create(BookDto bookDto) {

        /*Optional<Book> optionalBook = bookRepository.findByTitle(bookDto.getTitle());*/
        /*if (optionalBook.isPresent()) {
            throw new AlreadyExistsException("book " + bookDto.getTitle() + " already exists");
        }*/
       /* if (bookDto.getAuthorDto() == null) {
            throw new NotFoundException("author is required");
        }*/
        Optional<Author> optionalAuthor = authorRepository.findById(bookDto.getAuthor().getId());

        Book newBook = bookMapper.convertToBook(bookDto);
        newBook.setAuthor(optionalAuthor.get());
        System.out.println(optionalAuthor);
        System.out.println(newBook);
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
