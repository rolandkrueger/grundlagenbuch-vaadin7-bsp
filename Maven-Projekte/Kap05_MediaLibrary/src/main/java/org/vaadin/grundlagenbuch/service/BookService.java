package org.vaadin.grundlagenbuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.grundlagenbuch.elasticsearch.repository.BookElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Book;
import org.vaadin.grundlagenbuch.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookElasticsearchRepository bookElasticsearchRepository;


    @Autowired
    public BookService(BookRepository bookRepository, BookElasticsearchRepository bookElasticsearchRepository) {
        this.bookRepository = bookRepository;
        this.bookElasticsearchRepository = bookElasticsearchRepository;
    }

    public Book save(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public List<Book> searchBooks(String searchTerm) {
        return bookElasticsearchRepository.findByTitleOrAuthor(searchTerm, searchTerm);
    }
}
