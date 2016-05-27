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
  private BookElasticsearchRepository bookESRepository;

  @Autowired
  public BookService(BookRepository bookRepository, BookElasticsearchRepository bookESRepository) {
    this.bookRepository = bookRepository;
    this.bookESRepository = bookESRepository;
  }

  public Book save(Book book) {
    Book savedBook = bookRepository.save(book);
    bookESRepository.save(savedBook);
    return savedBook;
  }

  public Book findById(Long id) {
    return bookRepository.findOne(id);
  }

  public void deleteBook(Book book) {
    bookRepository.delete(book);
    bookESRepository.delete(book);
  }

  public Iterable<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public List<Book> searchBooks(String searchTerm) {
    return bookESRepository.findByTitleOrAuthorOrPublisher(searchTerm,
      searchTerm,
      searchTerm);
  }

  public void deleteAllBooks() {
    bookRepository.deleteAllInBatch();
    bookESRepository.deleteAll();
  }
}
